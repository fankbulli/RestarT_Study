package pdf.replace;

import lombok.Data;

@Data
public class MatchItem {
    private Integer pageNum;
    private String keyWord;
    private String content;
    private float x;
    private float y;
    private float fontHeight=24;
    private float fontWidth;
    private float pageHeight;
    private float pageWidth;
}
