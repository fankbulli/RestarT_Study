import cn.hutool.core.util.StrUtil;
import com.deepoove.poi.XWPFTemplate;
import com.deepoove.poi.data.PictureRenderData;
import com.deepoove.poi.data.PictureType;
import com.deepoove.poi.data.Pictures;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xwpf.usermodel.*;

import javax.xml.crypto.Data;
import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
//
//// docx 文档的高级类对象
//        XWPFDocument document = null;
//                InputStream in = null;
//                OutputStream os = null;
//                FileInputStream[] fileInputStreams = null;
//                try {
//                in = new FileInputStream(src);
//                //获取docx解析对象
//                document = new XWPFDocument(in);
//                os = new FileOutputStream(dest);
//                changeTable(document,data,null);
//                document.write(os);
//                in.close();
//                document.close();
//                os.close();
//                //图片
//                Map<String, FileInputStream> picMap = new HashMap<>();
//        List<HidFileDto> files = Lists.newArrayList();
//        dto.getRecordList().forEach(e->{
//        e.getContent().forEach(f->{
//        if (CollectionUtils.isNotEmpty(f.getFiles())){
//        files.addAll(f.getFiles());
//        }
//        });
//        });
//        fileInputStreams = new FileInputStream[files.size()];
//        for (int i = 0; i < files.size(); i++) {
//        HidFileDto fileDto = files.get(i);
//        fileInputStreams[i] = new FileInputStream(picUrl+fileDto.getRelId()+"\\"+fileDto.getId()+"."+fileDto.getFileName().split("\\.")[1]);
//        picMap.put("{{@"+fileDto.getId()+"}}",fileInputStreams[i]);
//        }
//        in = new FileInputStream(dest);
//        //获取docx解析对象
//        document = new XWPFDocument(in);
//        changeTable(document,null,picMap);
//        // 设置强制下载不打开
//        response.setContentType("application/force-download");
//        // 设置文件名
//        response.setHeader("Content-disposition", "attachment;filename=" + URLEncoder.encode(dto.getPatrolDate()+dto.getPointName() + ".doc", "UTF-8"));
//
//        document.write(response.getOutputStream());
////            document.write(os);
//        }catch (IOException e){
//        e.printStackTrace();
//        } catch (InvalidFormatException e) {
//        e.printStackTrace();
//        } finally {
//        try {
//        if (in != null) {
//        in.close();
//        }
//        if (document != null) {
//        document.close();
//        }
//        if (os != null) {
//        os.close();
//        }
//        for (FileInputStream fis : fileInputStreams){
//        fis.close();
//        }
//        File file = new File(dest);
//        file.delete();
//        } catch (Exception e) {
//
//        e.printStackTrace();
//        }
//        }

public class Doc {
    public static void main(String[] args) {
        String src =  "C:\\Users\\user\\Desktop\\qq.docx";
        String dest =  "C:\\Users\\user\\Desktop\\qq2.docx";
        XWPFDocument document = null;
        InputStream in = null;
        OutputStream os = null;
        FileInputStream gfs = null;
        try {
            gfs = new FileInputStream("C:\\Users\\user\\Pictures\\e26f53d0bec18bc5996db4d860fe0eb.jpg");
            in = new FileInputStream(src);
            //获取docx解析对象
            document = new XWPFDocument(in);
            List<XWPFParagraph> paragraphs = document.getParagraphs();
            for (XWPFParagraph paragraph:paragraphs){
                String text = paragraph.getText();
                int size = paragraph.getRuns().size();
                if (text.contains("{{")){
                    paragraph.createRun().addPicture(gfs, PictureType.JPEG.type(),"图1.jpg",2009000,4000000);
                    for (int i = 0 ;i<size;i++){
                        paragraph.removeRun(0);
                    }
                }
            }
            os = new FileOutputStream(dest);
            document.write(os);
//            os1 = new FileOutputStream(dest1);

        }catch (IOException e){
            System.out.println(e.getMessage());
        } catch (InvalidFormatException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (in != null) {
                    in.close();
                }
                if (document != null) {
                    document.close();
                }
                if (os != null) {
                    os.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 为表格插入数据，行数不够添加新行
     *
     */
    /**
     * 替换表格对象方法
     *
     * @param document docx解析对象
     * @param textMap  需要替换的信息集合
     */
    public  void changeTable(XWPFDocument document, Map<String, String> textMap,Map<String, FileInputStream> picMap ) throws IOException, InvalidFormatException {
        //获取表格对象集合
        List<XWPFTable> tables = document.getTables();
        for (int i = 0; i < tables.size(); i++) {
            //只处理行数大于等于2的表格，且不循环表头
            XWPFTable table = tables.get(i);
            if (table.getRows().size() > 1) {
                //判断表格内容是否可以替换
                String cellText = table.getText();
                if (null!=textMap){
                    if (StrUtil.isNotBlank(cellText) && cellText.contains("#")){
                        List<XWPFTableRow> rows = table.getRows();
                        //遍历表格,并替换模板
                        eachTable(rows, textMap,picMap);
                    }
                }
                if (null!=picMap){
                    if (StrUtil.isNotBlank(cellText) && cellText.contains("{{@")){
                        List<XWPFTableRow> rows = table.getRows();
                        //遍历表格,并替换模板
                        eachTable(rows, textMap,picMap);
                    }
                }
            }
        }
    }


    /**
     * 遍历表格
     *
     * @param rows    表格行对象
     * @param textMap 需要替换的信息集合
     */
    public void eachTable(List<XWPFTableRow> rows, Map<String, String> textMap,Map<String, FileInputStream> picMap) throws IOException, InvalidFormatException {
        for (XWPFTableRow row : rows) {
            List<XWPFTableCell> cells = row.getTableCells();
            for (XWPFTableCell cell : cells) {
                //判断单元格内容是否可以替换
                String cellText = cell.getText();
                if (null!=textMap){
                    if (StrUtil.isNotBlank(cellText) && cellText.contains("#")) {
                        List<XWPFParagraph> paragraphs = cell.getParagraphs();
                        for (XWPFParagraph paragraph : paragraphs) {
                            String text = paragraph.getText();
                            int size = paragraph.getRuns().size();
                            if (textMap.containsKey(text)){
                                String value = textMap.get(text);
                                if (value.contains("&")){
                                    String[] strings = value.split("&");
                                    for (String s :strings){
                                        paragraph.createRun().setText(s);
                                    }
                                }else {
                                    paragraph.createRun().setText(textMap.get(text));
                                }
                                for (int i = 0 ;i<size;i++){
                                    paragraph.removeRun(0);
                                }
                            }
                        }
                    }
                }
                if(null!=picMap){
                    if (StrUtil.isNotBlank(cellText) && cellText.contains("{{@")) {
                        List<XWPFParagraph> paragraphs = cell.getParagraphs();
                        for (XWPFParagraph paragraph : paragraphs) {
                            int size = paragraph.getRuns().size();
                            List<XWPFRun> runs = paragraph.getRuns();
                            String pText = paragraph.getText();
                            if (pText.contains("{{@")){
                                for (int i=0;i<size;i++){
                                    String text = runs.get(0).text();
                                    if (text.contains("{{@")){
                                        paragraph.createRun().addTab();
                                        paragraph.createRun().addPicture(picMap.get(text.replace("\r","")), PictureType.JPEG.type(),text+".jpg",80*10000,130*10000);
                                        paragraph.createRun().addTab();
                                    }else {
                                        if (i!=0){
                                            paragraph.createRun().addBreak(BreakType.TEXT_WRAPPING);
                                        }
                                        paragraph.createRun().setText(text.replace("\r",""));
                                        paragraph.createRun().addBreak(BreakType.TEXT_WRAPPING);
                                    }
                                    paragraph.removeRun(0);
                                }
                            }
                        }
                    }
                }

            }
        }
    }
}
