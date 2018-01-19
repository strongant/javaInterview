package com.strongant.poi;

import org.apache.poi.xslf.usermodel.XMLSlideShow;
import org.apache.poi.xslf.usermodel.XSLFSlide;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.List;

/**
 * @author <a href="mailto:strongant1994@gmail.com">strongant</a>
 * @since 2017/8/20
 */
public class PPTToImage {
	public static void main(String[] args) throws Exception {
		FileInputStream is = new FileInputStream("src/1435896292-59bd46ef5f7ff.pptx");
		XMLSlideShow ppt = new XMLSlideShow(is);
		is.close();

		double zoom = 1; // magnify it by 2
		AffineTransform at = new AffineTransform();
		at.setToScale(zoom, zoom);

		Dimension pgsize = ppt.getPageSize();

		List<XSLFSlide> slide = ppt.getSlides();


		for (int i = 0; i < slide.size(); i++) {
			BufferedImage img = new BufferedImage((int)Math.ceil(pgsize.width*zoom), (int)Math.ceil(pgsize.height*zoom), BufferedImage.TYPE_INT_RGB);
			Graphics2D graphics = img.createGraphics();
			graphics.setTransform(at);

			graphics.setPaint(Color.white);
			graphics.fill(new Rectangle2D.Float(0, 0, pgsize.width, pgsize.height));
			slide.get(i).draw(graphics);



			FileOutputStream out = new FileOutputStream("slide-" + (i + 1) + ".png");
			javax.imageio.ImageIO.write(img, "png", out);
			out.close();
		}

	}


}
