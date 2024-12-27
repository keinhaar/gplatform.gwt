package de.exware.gplatform.gwt.element;

import com.google.gwt.canvas.dom.client.Context2d;
import com.google.gwt.dom.client.ImageElement;

import de.exware.gplatform.element.GPContext2d;
import de.exware.gplatform.element.GPImageElement;

public class GwtGPContext2d implements GPContext2d
{
    private Context2d context2d;
    
    public GwtGPContext2d(Context2d c2d)
    {
        this.context2d = c2d;
    }

    @Override
    public void setTransform(double m11, double m12, double m21, double m22, double dx, double dy)
    {
        context2d.setTransform(m11, m12, m21, m22, dx, dy);
    }

    @Override
    public void save()
    {
        context2d.save();
    }

    @Override
    public void translate(double x, double y)
    {
        context2d.translate(x, y);
    }

    @Override
    public void moveTo(double x, double y)
    {
        context2d.moveTo(x, y);
    }

    @Override
    public void lineTo(int x, int y)
    {
        context2d.lineTo(x, y);
    }

    @Override
    public void stroke()
    {
        context2d.stroke();
    }

    @Override
    public void restore()
    {
        context2d.restore();
    }

    @Override
    public void rect(int x, int y, int width, int height)
    {
        context2d.rect(x, y, width, height);
    }

    @Override
    public void beginPath()
    {
        context2d.beginPath();
    }

    @Override
    public void bezierCurveTo(double x1, double y1, double x2, double y2, double x, double y)
    {
        context2d.bezierCurveTo(x1, y1, x2, y2, x, y);
    }

    @Override
    public void fill()
    {
        context2d.fill();
    }

    @Override
    public void fillRect(int x, int y, int width, int height)
    {
        context2d.fillRect(x, y, width, height);
    }

    @Override
    public void fillText(String text, int x, int y)
    {
        context2d.fillText(text, x, y);
    }

    @Override
    public void setStrokeColor(String hexColor)
    {
        context2d.setStrokeStyle(hexColor);
    }

    @Override
    public void setFillColor(String hexColor)
    {
        context2d.setFillStyle(hexColor);
    }

    @Override
    public void rotate(double i)
    {
        context2d.rotate(i);
    }

    @Override
    public void scale(double x, double y)
    {
        context2d.scale(x, y);
    }

    @Override
    public void setFont(String cssFontDescription)
    {
        context2d.setFont(cssFontDescription);
    }

    @Override
    public void drawImage(GPImageElement imageElement, double x, double y)
    {
        GwtGPImageElement gpie = (GwtGPImageElement) imageElement;
        context2d.drawImage((ImageElement)gpie.getElement(), x, y);
    }

    @Override
    public void drawImage(GPImageElement imageElement, double x, double y, double w, double h)
    {
        GwtGPImageElement gpie = (GwtGPImageElement) imageElement;
        context2d.drawImage((ImageElement)gpie.getElement(), x, y, w, h);
    }

    @Override
    public void drawImage(GPImageElement imageElement, double srcX, double srcY, double srcW, double srcH, double x, double y, double w, double h)
    {
        GwtGPImageElement gpie = (GwtGPImageElement) imageElement;
        context2d.drawImage((ImageElement)gpie.getElement(), srcX, srcY, srcW, srcH, x, y, w, h);
    }

}
