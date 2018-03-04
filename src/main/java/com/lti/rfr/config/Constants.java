package com.lti.rfr.config;

import org.apache.poi.hssf.usermodel.HSSFFormulaEvaluator;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.xssf.usermodel.XSSFFormulaEvaluator;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * Application constants.
 */
public final class Constants {

    // Regex for acceptable logins
    public static final String LOGIN_REGEX = "^[_'.@A-Za-z0-9-]*$";

    public static final String SYSTEM_ACCOUNT = "system";
    public static final String ANONYMOUS_USER = "anonymoususer";
    public static final String DEFAULT_LANGUAGE = "en";
    
    public static final String RFR_DATE_FORMAT = "MMM dd, yyyy";

    public final static String DELIMITER = "#%#%";

    public static final XSSFWorkbook WB_XSSF = new XSSFWorkbook();
    public static final HSSFWorkbook WB_HSSF = new HSSFWorkbook();

    public static final DataFormatter FORMATTER = new DataFormatter();
    public static final FormulaEvaluator EV_XSSF = new XSSFFormulaEvaluator(WB_XSSF);
    public static final FormulaEvaluator EV_HSSF = new HSSFFormulaEvaluator(WB_HSSF);

    public static final String CSV = ".csv";
    public static final String XLSX = ".xlsx";
    public static final String XLS = ".xls";
    public static final String INVALID = "invalid";
    public static final String NA = "N/A";
    
    private Constants() {
    }
}
