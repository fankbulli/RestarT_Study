/*
 * Copyright (c) 2021. Shanghai TongYan Civil Engineering Technology Corp., Ltd. All rights reserved.
 */
package pdf.replace;

import com.google.common.collect.Lists;
import com.itextpdf.awt.geom.Rectangle2D;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.parser.ImageRenderInfo;
import com.itextpdf.text.pdf.parser.RenderListener;
import com.itextpdf.text.pdf.parser.TextRenderInfo;
import lombok.Data;

import java.util.List;

/**
 * Description: 一句话描述此类
 *
 * @author 钟鸣
 * @Date 2021/1/27 16:35
 */
@Data
public class KeyWordPositionListener implements RenderListener {
    private String keyword;
    private Integer pageNumber;
    private Rectangle curPageSize;
    private List<MatchItem> allItems= Lists.newArrayList();
    private List<MatchItem> matches= Lists.newArrayList();
    @Override
    public void beginTextBlock() {

    }

    @Override
    public void renderText(TextRenderInfo textRenderInfo) {
        //获取字符
        String content = textRenderInfo.getText();
        Rectangle2D.Float textRectangle = textRenderInfo.getDescentLine().getBoundingRectange();

        MatchItem item = new MatchItem();
        item.setContent(content);
        item.setPageNum(pageNumber);
        item.setFontHeight(textRectangle.height == 0 ? 12:textRectangle.height);//默认12
        item.setFontWidth(textRectangle.width);
        item.setPageHeight(curPageSize.getHeight());
        item.setPageWidth(curPageSize.getWidth());
        item.setX((float)textRectangle.getX());
        item.setY((float)textRectangle.getY());

        //若keyword是单个字符，匹配上的情况
        if(content.equalsIgnoreCase(keyword)) {
            matches.add(item);
        }
        //保存所有的项
        allItems.add(item);
    }

    @Override
    public void endTextBlock() {

    }

    @Override
    public void renderImage(ImageRenderInfo imageRenderInfo) {

    }
}
