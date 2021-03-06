package com.ontimize.plaf.painter;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics2D;

import javax.swing.JComponent;
import javax.swing.UIManager;

public class OTableButtonPainter extends AbstractOButtonPainter{
	
	public static  Color defaultFocusBgColor = new Color(0x366581);
	protected Color focusBgColor;

	protected PaintContext ctx;
	protected int state;
	public OTableButtonPainter(int state, PaintContext ctx) {
		super(state, ctx);
		this.state = state;
		this.ctx = ctx;
		init();
	}

	@Override
	protected void doPaint(Graphics2D g, JComponent c, int width, int height,
			Object[] extendedCacheKeys) {
		 componentColors = extendedCacheKeys;
		 switch(state) {
         case BACKGROUND_DEFAULT_FOCUSED: paintBackgroundDefaultAndFocused(g); break;
         case BACKGROUND_FOCUSED: paintBackgroundFocused(g); break;
		 }
	}
	
	@Override
	protected String getComponentKeyName() {
		return "\"TableButton\"";
	}
	
	protected void init (){
		super.init();
		Object obj = UIManager.getDefaults().get("\"TableButton\"[Focused].background");
		if(obj instanceof Color){
			this.focusBgColor = (Color)obj;
		}else{
			this.focusBgColor = defaultFocusBgColor;
		}
		
	}

	
	protected void paintBackgroundDefaultAndFocused(Graphics2D g) {
    	AlphaComposite old = (AlphaComposite) g.getComposite();
    	g.setComposite(getDerivedAlphaComposite());
        roundRect = decodeRoundRect4();
        g.setPaint(focusBgColor!=null ? focusBgColor : defaultFocusBgColor);
        g.fill(roundRect);
        g.setComposite(old);
    }
	
	protected void paintBackgroundFocused(Graphics2D g) {
    	AlphaComposite old = (AlphaComposite) g.getComposite();
    	g.setComposite(getDerivedAlphaComposite());
        roundRect = decodeRoundRect4();
        g.setPaint(focusBgColor!=null ? focusBgColor : defaultFocusBgColor);
        g.fill(roundRect);
        g.setComposite(old);
    }

}
