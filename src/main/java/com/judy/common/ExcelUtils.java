package com.judy.common;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * Excel 업로드 관련
 */
public class ExcelUtils {

    /**
     * 웹에서 업로드한 Excel 파일 > <pre>List<Map, Object></pre> 형태로 변환
     * - 첫번째 시트명 : table명
     * - 첫번째 행 : 컬럼명
     */
    private Map<String, Object> excelToList(MultipartFile file) throws Exception {
        InputStream fis = file.getInputStream();
        Map<String, Object> result = new HashMap<>();

        // 어떤 table인지 모르므로 map형식
        List<Map<String, String>> list = new ArrayList<>();

        Workbook workbook = new XSSFWorkbook(fis);
        // 첫번재 시트
        Sheet sheet = workbook.getSheetAt(0);
        String tableName = sheet.getSheetName();

        int firstRowNum = sheet.getFirstRowNum();
        int lastRowNum = sheet.getLastRowNum();

        Row firstRow = sheet.getRow(firstRowNum);

        // 컬럼사이즈
        int columnSize = firstRow.getLastCellNum();

        List<String> colNames = new ArrayList<>();

        for (int i = 0; i < columnSize; i += 1) {
            Cell cell = firstRow.getCell(i);
            colNames.add(cell.getStringCellValue());
        }

        // 행별 작업
        for (int i = firstRowNum + 1; i <= lastRowNum; i += 1) {
            Row row = sheet.getRow(i);

            Map<String, String> data = new HashMap<>();
            for (int j = 0; j < columnSize; j += 1) {
                if (sheet.isColumnHidden(j)) {
                    continue;
                }
                Cell cell = row.getCell(j);

                if (cell == null || cell.getCellType() == CellType.BLANK) {
                    // empty
                    data.put(colNames.get(j), null);
                } else {
                    data.put(colNames.get(j), cell.getStringCellValue());
                }

            }

            list.add(data);
        }

        result.put("table", tableName);
        result.put("list", list);

        return result;

    }   // END
}
