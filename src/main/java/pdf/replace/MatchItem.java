/*
 * Copyright (c) 2021. Shanghai TongYan Civil Engineering Technology Corp., Ltd. All rights reserved.
 */
package pdf.replace;

import lombok.Data;

/**
 * Description: 一句话描述此类
 *
 * @author 钟鸣
 * @Date 2021/1/27 16:33
 */
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
