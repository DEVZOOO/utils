package com.judy.utils.service;

import com.judy.utils.utils.ExcelUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

@Service
@Slf4j
public class UtilsService {

    /**
     * 업로드한 Excel 파일을 List로 변환
     */
    public Map<String, Object> convertExcel(MultipartFile file) throws Exception {
        Map<String, Object> result = ExcelUtils.excelToList(file);

        return result;
    }
}
