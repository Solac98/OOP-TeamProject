package GUI;

import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;


import javax.swing.JButton;

public class CButton extends JButton {
	public CButton() { super(); decorate(); } 
	public CButton(String text) { super(text); decorate(); } 
	protected void decorate() { setBorderPainted(false); setOpaque(false); }

	@Override
	protected void paintComponent(Graphics g) {
		int width = getWidth()-5; 
		int height = getHeight(); 
		Graphics2D graphics = (Graphics2D) g; 
		graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON); 
		graphics.setColor(getBackground());
		graphics.fillRoundRect(0, 0, width, height, 30, 30); 
				
		FontMetrics fontMetrics = graphics.getFontMetrics(); 
		Rectangle stringBounds;
		graphics.setColor(getForeground());
		graphics.setFont(getFont()); 
		stringBounds = fontMetrics.getStringBounds(getText(), graphics).getBounds();
		int textX = (width - stringBounds.width) / 2;
		int textY = (height - stringBounds.height) / 2 + fontMetrics.getAscent(); 
		graphics.drawString(getText(), textX, textY);
 
		graphics.dispose(); 
		super.paintComponent(g);
	}
	
	
	


}
