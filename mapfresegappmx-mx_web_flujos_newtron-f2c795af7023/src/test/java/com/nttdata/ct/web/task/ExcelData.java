package com.nttdata.ct.web.task;

import net.minidev.json.JSONArray;
import net.minidev.json.JSONObject;
import net.minidev.json.parser.JSONParser;
import net.minidev.json.parser.ParseException;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.*;


public class ExcelData {

    public static String readExcel(String sheetName, int rowNumber, int cellNumber) {
        try {
            String pathFirst = System.getProperty("user.dir");
            File file = new File(pathFirst + "/src/test/resources/data/dataWebAutomoviles.xlsx");
            FileInputStream fileInputStream = new FileInputStream(file);
            XSSFWorkbook newWorkBook = new XSSFWorkbook(fileInputStream);
            XSSFSheet newSheet = newWorkBook.getSheet(sheetName);
            XSSFRow row = newSheet.getRow(rowNumber);
            XSSFCell cell = row.getCell(cellNumber);
            return cell.getStringCellValue();
        } catch (Exception e) {
            return null;
        }
    }
    public static String readExcelRec(String sheetName, int rowNumber, int cellNumber) {
        try {
            String pathFirst = System.getProperty("user.dir");
            File file = new File(pathFirst + "/src/test/resources/data/dataWebAutomovilesRec.xlsx");
            FileInputStream fileInputStream = new FileInputStream(file);
            XSSFWorkbook newWorkBook = new XSSFWorkbook(fileInputStream);
            XSSFSheet newSheet = newWorkBook.getSheet(sheetName);
            XSSFRow row = newSheet.getRow(rowNumber);
            XSSFCell cell = row.getCell(cellNumber);
            return cell.getStringCellValue();
        } catch (Exception e) {
            return null;
        }
    }

    public static void writeJsonTask(String resultText) {
        try {
            String pathFirst = System.getProperty("user.dir");
            File file = new File(pathFirst + "/src/test/java/com/nttdata/ct/web/varTemporales/NombreExcel.json");
            String file1 = file.getAbsolutePath();
            JSONObject obj = new JSONObject();
            obj.put("nombreCsv", resultText);
            JSONArray rfc = new JSONArray();
            rfc.add(obj);
            FileWriter file2 = new FileWriter(file1, false);
            file2.write(rfc.toJSONString());
            file2.close();
        } catch (Exception e) {
        }

    }

    public static String readJsonTask() {
        String pathFirst = System.getProperty("user.dir");
        File file = new File(pathFirst + "/src/test/java/com/nttdata/ct/web/varTemporales/NombreExcel.json");
        String file1 = file.getAbsolutePath();
        JSONParser parser = new JSONParser();
        try (FileReader reader = new FileReader(file1)) {
            Object obj = parser.parse(reader);
            JSONArray arrayList = (JSONArray) obj;
            JSONObject rfc = (JSONObject) arrayList.get(0);
            String element = rfc.getAsString("nombreCsv");
            return element;
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    public static void writeJsonAgente(String resultText) {
        try {
            String pathFirst = System.getProperty("user.dir");
            File file = new File(pathFirst + "/src/test/java/com/nttdata/ct/web/varTemporales/RfcDocumento.json");
            String file1 = file.getAbsolutePath();
            JSONObject obj = new JSONObject();
            obj.put("RfcDocumento", resultText);
            JSONArray rfc = new JSONArray();
            rfc.add(obj);
            FileWriter file2 = new FileWriter(file1, false);
            file2.write(rfc.toJSONString());
            file2.close();
        } catch (Exception e) {
        }

    }

    public static String readJsonAgente() {
        String pathFirst = System.getProperty("user.dir");
        File file = new File(pathFirst + "/src/test/java/com/nttdata/ct/web/varTemporales/RfcDocumento.json");
        String file1 = file.getAbsolutePath();
        JSONParser parser = new JSONParser();
        try (FileReader reader = new FileReader(file1)) {
            Object obj = parser.parse(reader);
            JSONArray arrayList = (JSONArray) obj;
            JSONObject rfc = (JSONObject) arrayList.get(0);
            String element = rfc.getAsString("RfcDocumento");
            return element;
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    public static void writeJsonSuplemento(String resultText) {
        try {
            String pathFirst = System.getProperty("user.dir");
            File file = new File(pathFirst + "/src/test/java/com/nttdata/ct/web/varTemporales/PolizaSuplemento.json");
            String file1 = file.getAbsolutePath();
            JSONObject obj = new JSONObject();
            obj.put("polizaSuplemento", resultText);
            JSONArray rfc = new JSONArray();
            rfc.add(obj);
            FileWriter file2 = new FileWriter(file1, false);
            file2.write(rfc.toJSONString());
            file2.close();
        } catch (Exception e) {
        }
    }

    public static void writeJsonPresupuesto(String resultText) {
        try {
            String pathFirst = System.getProperty("user.dir");
            File file = new File(pathFirst + "/src/test/java/com/nttdata/ct/web/varTemporales/PolizaPresupuesto.json");
            String file1 = file.getAbsolutePath();
            JSONObject obj = new JSONObject();
            obj.put("polizaPresupuesto", resultText);
            JSONArray rfc = new JSONArray();
            rfc.add(obj);
            FileWriter file2 = new FileWriter(file1, false);
            file2.write(rfc.toJSONString());
            file2.close();
        } catch (Exception e) {
        }
    }

    public static String readJsonPresupuesto() {
        String pathFirst = System.getProperty("user.dir");
        File file = new File(pathFirst + "/src/test/java/com/nttdata/ct/web/varTemporales/PolizaPresupuesto.json");
        String file1 = file.getAbsolutePath();
        JSONParser parser = new JSONParser();
        try (FileReader reader = new FileReader(file1)) {
            Object obj = parser.parse(reader);
            JSONArray arrayList = (JSONArray) obj;
            JSONObject rfc = (JSONObject) arrayList.get(0);
            String element = rfc.getAsString("polizaPresupuesto");
            return element;
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    public static void writeJsonIndividual(String resultText) {
        try {
            String pathFirst = System.getProperty("user.dir");
            File file = new File(pathFirst + "/src/test/java/com/nttdata/ct/web/varTemporales/PolizaIndividual.json");
            String file1 = file.getAbsolutePath();
            JSONObject obj = new JSONObject();
            obj.put("polizaIndividual", resultText);
            JSONArray rfc = new JSONArray();
            rfc.add(obj);
            FileWriter file2 = new FileWriter(file1, false);
            file2.write(rfc.toJSONString());
            file2.close();
        } catch (Exception e) {
        }
    }

    public static String readJsonIndividual() {
        String pathFirst = System.getProperty("user.dir");
        File file = new File(pathFirst + "/src/test/java/com/nttdata/ct/web/varTemporales/PolizaIndividual.json");
        String file1 = file.getAbsolutePath();
        JSONParser parser = new JSONParser();
        try (FileReader reader = new FileReader(file1)) {
            Object obj = parser.parse(reader);
            JSONArray arrayList = (JSONArray) obj;
            JSONObject rfc = (JSONObject) arrayList.get(0);
            String element = rfc.getAsString("polizaIndividual");
            return element;
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    public static void writeJsonSiniestro(String dataSave, String resultText) {
        String pathFirst = System.getProperty("user.dir");
        File file = new File(pathFirst + "/src/test/java/com/nttdata/ct/web/varTemporales/PolizaSiniestro.json");
        String fileFirst = file.getAbsolutePath();
        JSONParser parser = new JSONParser();
        try (FileReader reader = new FileReader(fileFirst)) {
            Object obj = parser.parse(reader);
            JSONArray arrayList = (JSONArray) obj;
            JSONObject rfcIndex = (JSONObject) arrayList.get(0);
            rfcIndex.put(dataSave, resultText);
            FileWriter file1 = new FileWriter(fileFirst, false);
            file1.write(arrayList.toJSONString());
            file1.close();
        } catch (Exception e) {
        }
    }

    public static void writeJsonSiniestroDMP(String dataSave, String resultText) {
        String pathFirst = System.getProperty("user.dir");
        File file = new File(pathFirst + "/src/test/java/com/nttdata/ct/web/varTemporales/PolizaSiniestroDMP.json");
        String fileFirst = file.getAbsolutePath();
        JSONParser parser = new JSONParser();
        try (FileReader reader = new FileReader(fileFirst)) {
            Object obj = parser.parse(reader);
            JSONArray arrayList = (JSONArray) obj;
            JSONObject rfcIndex = (JSONObject) arrayList.get(0);
            rfcIndex.put(dataSave, resultText);
            FileWriter file1 = new FileWriter(fileFirst, false);
            file1.write(arrayList.toJSONString());
            file1.close();
        } catch (Exception e) {
        }
    }

    public static String readJsonSiniestrodmp(String datoLeer) {
        String pathFirst = System.getProperty("user.dir");
        File file = new File(pathFirst + "/src/test/java/com/nttdata/ct/web/varTemporales/PolizaSiniestroDMP.json");
        String file1 = file.getAbsolutePath();
        JSONParser parser = new JSONParser();
        try (FileReader reader = new FileReader(file1)) {
            Object obj = parser.parse(reader);
            JSONArray arrayList = (JSONArray) obj;
            JSONObject rfc = (JSONObject) arrayList.get(0);
            String element = rfc.getAsString(datoLeer);
            return element;
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    public static String readJsonSiniestro(String datoLeer) {
        String pathFirst = System.getProperty("user.dir");
        File file = new File(pathFirst + "/src/test/java/com/nttdata/ct/web/varTemporales/PolizaSiniestro.json");
        String file1 = file.getAbsolutePath();
        JSONParser parser = new JSONParser();
        try (FileReader reader = new FileReader(file1)) {
            Object obj = parser.parse(reader);
            JSONArray arrayList = (JSONArray) obj;
            JSONObject rfc = (JSONObject) arrayList.get(0);
            String element = rfc.getAsString(datoLeer);
            return element;
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    public static String readJsonSiniestroDMP(String datoLeer) {
        String pathFirst = System.getProperty("user.dir");
        File file = new File(pathFirst + "/src/test/java/com/nttdata/ct/web/varTemporales/PolizaSiniestroDMP.json");
        String file1 = file.getAbsolutePath();
        JSONParser parser = new JSONParser();
        try (FileReader reader = new FileReader(file1)) {
            Object obj = parser.parse(reader);
            JSONArray arrayList = (JSONArray) obj;
            JSONObject rfc = (JSONObject) arrayList.get(0);
            String element = rfc.getAsString(datoLeer);
            return element;
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }



    public static String readJsonPoliza(String datoLeer) {
        String pathFirst = System.getProperty("user.dir");
        File file = new File(pathFirst + "/src/test/java/com/nttdata/ct/web/varTemporales/Polizas.json");
        String file1 = file.getAbsolutePath();
        JSONParser parser = new JSONParser();
        try (FileReader reader = new FileReader(file1)) {
            Object obj = parser.parse(reader);
            JSONArray arrayList = (JSONArray) obj;
            JSONObject rfc = (JSONObject) arrayList.get(0);
            String element = rfc.getAsString(datoLeer);
            return element;
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    public static void writeJsonTemporal2(String resultText) {
        try {
            String pathFirst = System.getProperty("user.dir");
            File file = new File(pathFirst + "/src/test/java/com/nttdata/ct/web/varTemporales/VarTemporal2.json");
            String file1 = file.getAbsolutePath();
            JSONObject obj = new JSONObject();
            obj.put("varTemporal2", resultText);
            JSONArray rfc = new JSONArray();
            rfc.add(obj);
            FileWriter file2 = new FileWriter(file1, false);
            file2.write(rfc.toJSONString());
            file2.close();
        } catch (Exception e) {
        }
    }

    public static void writeJsonTemporal1(String resultText) {
        try {
            String pathFirst = System.getProperty("user.dir");
            File file = new File(pathFirst + "/src/test/java/com/nttdata/ct/web/varTemporales/VarTemporal.json");
            String file1 = file.getAbsolutePath();
            JSONObject obj = new JSONObject();
            obj.put("varTemporal1", resultText);
            JSONArray rfc = new JSONArray();
            rfc.add(obj);
            FileWriter file2 = new FileWriter(file1, false);
            file2.write(rfc.toJSONString());
            file2.close();
        } catch (Exception e) {
        }
    }

    public static String readJsonSuplemento() {
        String pathFirst = System.getProperty("user.dir");
        File file = new File(pathFirst + "/src/test/java/com/nttdata/ct/web/varTemporales/PolizaSuplemento.json");
        String file1 = file.getAbsolutePath();
        JSONParser parser = new JSONParser();
        try (FileReader reader = new FileReader(file1)) {
            Object obj = parser.parse(reader);
            JSONArray arrayList = (JSONArray) obj;
            JSONObject rfc = (JSONObject) arrayList.get(0);
            String element = rfc.getAsString("polizaSuplemento");
            return element;
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    public static String readJsonTemporal1() {
        String pathFirst = System.getProperty("user.dir");
        File file = new File(pathFirst + "/src/test/java/com/nttdata/ct/web/varTemporales/VarTemporal.json");
        String file1 = file.getAbsolutePath();
        JSONParser parser = new JSONParser();
        try (FileReader reader = new FileReader(file1)) {
            Object obj = parser.parse(reader);
            JSONArray arrayList = (JSONArray) obj;
            JSONObject rfc = (JSONObject) arrayList.get(0);
            String element = rfc.getAsString("varTemporal1");
            System.out.println(element);
            return element;
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    public static String readJsonTemporal2() {
        String pathFirst = System.getProperty("user.dir");
        File file = new File(pathFirst + "/src/test/java/com/nttdata/ct/web/varTemporales/VarTemporal2.json");
        String file1 = file.getAbsolutePath();
        JSONParser parser = new JSONParser();
        try (FileReader reader = new FileReader(file1)) {
            Object obj = parser.parse(reader);
            JSONArray arrayList = (JSONArray) obj;
            JSONObject rfc = (JSONObject) arrayList.get(0);
            String element = rfc.getAsString("varTemporal2");
            System.out.println(element);
            return element;
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    public static void writeJsonTemporalFlotillas1(String resultText) {
        try {
            String pathFirst = System.getProperty("user.dir");
            File file = new File(pathFirst + "/src/test/java/com/nttdata/ct/web/varTemporales/VarTemporalFlotillas.json");
            String file1 = file.getAbsolutePath();
            JSONObject obj = new JSONObject();
            obj.put("varTemporalFlotillas", resultText);
            JSONArray rfc = new JSONArray();
            rfc.add(obj);
            FileWriter file2 = new FileWriter(file1, false);
            file2.write(rfc.toJSONString());
            file2.close();
        } catch (Exception e) {
        }
    }

    public static void writeJsonTemporalFlotillas2(String resultText) {
        try {
            String pathFirst = System.getProperty("user.dir");
            File file = new File(pathFirst + "/src/test/java/com/nttdata/ct/web/varTemporales/VarTemporal2Flotillas.json");
            String file1 = file.getAbsolutePath();
            JSONObject obj = new JSONObject();
            obj.put("poliza", resultText);
            JSONArray rfc = new JSONArray();
            rfc.add(obj);
            FileWriter file2 = new FileWriter(file1, false);
            file2.write(rfc.toJSONString());
            file2.close();
        } catch (Exception e) {
        }
    }

    public static String readJsonTemporal1Flotillas() {
        String pathFirst = System.getProperty("user.dir");
        File file = new File(pathFirst + "/src/test/java/com/nttdata/ct/web/varTemporales/VarTemporalFlotillas.json");
        String file1 = file.getAbsolutePath();
        JSONParser parser = new JSONParser();
        try (FileReader reader = new FileReader(file1)) {
            Object obj = parser.parse(reader);
            JSONArray arrayList = (JSONArray) obj;
            JSONObject rfc = (JSONObject) arrayList.get(0);
            String element = rfc.getAsString("varTemporalFlotillas");
            System.out.println(element);
            return element;
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    public static String readJsonTemporal2Flotillas() {
        String pathFirst = System.getProperty("user.dir");
        File file = new File(pathFirst + "/src/test/java/com/nttdata/ct/web/varTemporales/VarTemporal2Flotillas.json");
        String file1 = file.getAbsolutePath();
        JSONParser parser = new JSONParser();
        try (FileReader reader = new FileReader(file1)) {
            Object obj = parser.parse(reader);
            JSONArray arrayList = (JSONArray) obj;
            JSONObject rfc = (JSONObject) arrayList.get(0);
            String element = rfc.getAsString("varTemporal2Flotillas");
            System.out.println(element);
            return element;
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    public static String readJsonTemporalPolizaFlotillas() {
        String pathFirst = System.getProperty("user.dir");
        File file = new File(pathFirst + "/src/test/java/com/nttdata/ct/web/varTemporales/PolizaFlotillas.json");
        String file1 = file.getAbsolutePath();
        JSONParser parser = new JSONParser();
        try (FileReader reader = new FileReader(file1)) {
            Object obj = parser.parse(reader);
            JSONArray arrayList = (JSONArray) obj;
            JSONObject rfc = (JSONObject) arrayList.get(0);
            String element = rfc.getAsString("PolizaFlotillas");
            System.out.println(element);
            return element;
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    public static String readJson(String datoLeer) {
        String pathFirst = System.getProperty("user.dir");
        File file = new File(pathFirst + "/src/test/java/com/nttdata/ct/web/varTemporales/"+datoLeer+".json");
        String file1 = file.getAbsolutePath();
        JSONParser parser = new JSONParser();
        try (FileReader reader = new FileReader(file1)) {
            Object obj = parser.parse(reader);
            JSONArray arrayList = (JSONArray) obj;
            JSONObject rfc = (JSONObject) arrayList.get(0);
            String element = rfc.getAsString(datoLeer);
            return element;
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    public static void writeJson(String dataSave, String resultText) {
        try {
            if (dataSave.equals("PolizaFlotillas")) {
                String pathFirst = System.getProperty("user.dir");
                File file = new File(pathFirst + "/src/test/java/com/nttdata/ct/web/varTemporales/PolizaFlotillas.json");
                String fileFirst = file.getAbsolutePath();
                JSONObject obj1 = new JSONObject();
                obj1.put(dataSave, resultText);
                JSONArray rfc = new JSONArray();
                rfc.add(obj1);
                FileWriter file1 = new FileWriter(fileFirst, false);
                file1.write(rfc.toJSONString());
                file1.close();
            } else if (dataSave.equals("PolizaIndividual")) {
                String pathFirst = System.getProperty("user.dir");
                File file = new File(pathFirst + "/src/test/java/com/nttdata/ct/web/varTemporales/PolizaIndividual.json");
                String fileFirst = file.getAbsolutePath();
                JSONObject obj1 = new JSONObject();
                obj1.put(dataSave, resultText);
                JSONArray rfc = new JSONArray();
                rfc.add(obj1);
                FileWriter file1 = new FileWriter(fileFirst, false);
                file1.write(rfc.toJSONString());
                file1.close();
            } else if (dataSave.equals("PolizaSuplementoIndividual")) {
                String pathFirst = System.getProperty("user.dir");
                File file = new File(pathFirst + "/src/test/java/com/nttdata/ct/web/varTemporales/PolizaSuplementoIndividual.json");
                String fileFirst = file.getAbsolutePath();
                JSONObject obj1 = new JSONObject();
                obj1.put(dataSave, resultText);
                JSONArray rfc = new JSONArray();
                rfc.add(obj1);
                FileWriter file1 = new FileWriter(fileFirst, false);
                file1.write(rfc.toJSONString());
                file1.close();
            } else if (dataSave.equals("PolizaSuplementoFlotillas")) {
                String pathFirst = System.getProperty("user.dir");
                File file = new File(pathFirst + "/src/test/java/com/nttdata/ct/web/varTemporales/PolizaSuplementoFlotillas.json");
                String fileFirst = file.getAbsolutePath();
                JSONObject obj1 = new JSONObject();
                obj1.put(dataSave, resultText);
                JSONArray rfc = new JSONArray();
                rfc.add(obj1);
                FileWriter file1 = new FileWriter(fileFirst, false);
                file1.write(rfc.toJSONString());
                file1.close();
            }
        } catch (Exception e) {
        }
    }

    public static void writeJsonGlobal(String dataSave, String resultText) {
        String pathFirst = System.getProperty("user.dir");
        File file = new File(pathFirst + "/src/test/java/com/nttdata/ct/web/varTemporales/Polizas.json");
        String fileFirst = file.getAbsolutePath();
        JSONParser parser = new JSONParser();
        try (FileReader reader = new FileReader(fileFirst)) {
            Object obj = parser.parse(reader);
            JSONArray arrayList = (JSONArray) obj;
            JSONObject rfcIndex = (JSONObject) arrayList.get(0);
            rfcIndex.put(dataSave, resultText);
            FileWriter file1 = new FileWriter(fileFirst, false);
            file1.write(arrayList.toJSONString());
            file1.close();
        } catch (Exception e) {
        }
    }

    public static String readJsonGlobal(String datoLeer) {
        String pathFirst = System.getProperty("user.dir");
        File file = new File(pathFirst + "/src/test/java/com/nttdata/ct/web/varTemporales/Polizas.json");
        String file1 = file.getAbsolutePath();
        JSONParser parser = new JSONParser();
        try (FileReader reader = new FileReader(file1)) {
            Object obj = parser.parse(reader);
            JSONArray arrayList = (JSONArray) obj;
            JSONObject rfc = (JSONObject) arrayList.get(0);
            String element = rfc.getAsString(datoLeer);
            return element;
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    public static String readCsv(String buzonCobro) {
        String pathUser = System.getProperty("user.home");
        String[] parts = pathUser.toString().split("\\\\"); // Step 3: Split the string by backslash
        String userName = parts[parts.length - 1]; // Step 4: Access the desired part
        String csvFile = "\\\\SMX000CTX000V1\\Ctx_Data$\\"+userName+"\\Downloads\\"+buzonCobro; // Cambia esto a la ruta de tu archivo CSV
        System.out.println("Csv:++++++:"+ pathUser);
        //Usar en el local "\\\\SMX000CTX000V1\\Ctx_Data$\\"+userName
        //String uat = pathUser
//        String csvFile = pathUser+"\\Downloads\\"+buzonCobro; // Cambia esto a la ruta de tu archivo CSV
//        System.out.println("Csv:++++++:"+ csvFile);
        int targetRow = 4;
        int targetColumn = 0;
        String line;
        String splitBy = ",";
        int currentRow = 0;
        String cellValue;
        String nombreEnvio="";
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            while ((line = br.readLine()) != null) {
                if (currentRow == targetRow) {
                    String[] values = line.split(splitBy);
                    if (targetColumn < values.length) {
                        cellValue = values[targetColumn];
                        String[] valores = cellValue.split(";");
                        nombreEnvio = valores[6];
                        System.out.println(nombreEnvio);
                    } else {
                        System.out.println("La columna especificada no existe en esta fila.");
                    }
                    break; // Salimos una vez que encontramos la fila deseada
                }
                currentRow++;
            }
        } catch (IOException e) {
            return  null;
        }
        return nombreEnvio;
    }

    public static String readtxt(String buzonCobro) {
        String pathUser = System.getProperty("user.home");
        String[] parts = pathUser.toString().split("\\\\");
        String userName = parts[parts.length - 1];
        String file = "\\\\SMX000CTX000V1\\Ctx_Data$\\"+userName+"\\Downloads\\"+buzonCobro;

        //Usar en el local "\\\\SMX000CTX000V1\0\Ctx_Data$\\"+userName
        //String uat = pathUser
        //pathUser.replace("\"","\\");
        //String file = pathUser+"\\Documents\\"+buzonCobro; // Cambia esto a la ruta de tu archivo CSV
        //String file = pathUser+"\\"+buzonCobro; // Cambia esto a la ruta de tu archivo CSV
        System.out.println("TXT File:"+ file);
        int targetRow = 1;
        String line;
        int currentRow = 0;
        String nombreEnvio="";
        File fr = new File(file);
        try (BufferedReader br = new BufferedReader(new FileReader(fr))) {
            while ((line = br.readLine()) != null) {
                ArrayList<String> valores = new ArrayList<>();
                System.out.println(line);
                if (currentRow >= targetRow) {
                    String cadena = line.replaceAll("\\s","*");
                    StringTokenizer tokens = new StringTokenizer(cadena,"|");
                    while (tokens.hasMoreTokens()){
                        valores.add(tokens.nextToken());
                    }
                    if(!valores.get(3).endsWith("*")){
                        nombreEnvio=valores.get(4);
                        break;
                    }

                }
                currentRow++;
            }
            if(nombreEnvio==""){
                System.out.println("No existe registro de Poliza");
            }
        } catch (IOException e) {
            return  null;
        }
        return nombreEnvio;
    }

    public static ArrayList<String> readExcelSiniestros(String sheetName) {
        try {
            String pathFirst = System.getProperty("user.dir");
            File file = new File(pathFirst + "/src/test/resources/data/dataWebSiniestros.xlsx");
            FileInputStream fileInputStream = new FileInputStream(file);
            XSSFWorkbook newWorkBook = new XSSFWorkbook(fileInputStream);
            XSSFSheet newSheet = newWorkBook.getSheet(sheetName);
            ArrayList<String> datos = new ArrayList<>();
            System.out.println(newSheet.getLastRowNum());
            for (int i = 2; i<=newSheet.getLastRowNum(); i++){
                XSSFRow row = newSheet.getRow(i);
                XSSFCell cell = row.getCell(0);
                datos.add(cell.getStringCellValue());
            }
            //XSSFCell cell = row.getCell(cellNumber);
            //return cell.getStringCellValue();
            return datos;
        } catch (Exception e) {
            return null;
        }
    }


    public static void main(String[] args) {
        Date current = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/YYYY");
        String message = formatter.format(current);
        LocalDate currentDate = LocalDate.now();
//        String nombreExcel = ExcelData.readJsonTask();
//        String nombre = ExcelData.readCsv("gc_k_carga_buzon_cobro_34689.csv");
        System.out.println(message);
//        // Step 1: Get the current date
//        LocalDate currentDate = LocalDate.now();
//        // Step 2: Get the previous month
//        LocalDate previousMonth = currentDate.minusMonths(1);
//
//        // Step 3: Define a formatter for better readability of the output
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
//
//        // Step 4: Output the results
//        System.out.println("Current Date: " + currentDate.format(formatter));
//        System.out.println("Previous Month: " + previousMonth.format(formatter));

    }
}
