package de.exware.gplatform.gwt;

import com.google.gwt.dom.client.CanvasElement;
import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.ImageElement;
import com.google.gwt.dom.client.InputElement;
import com.google.gwt.dom.client.OptionElement;
import com.google.gwt.dom.client.SelectElement;
import com.google.gwt.dom.client.TextAreaElement;

import de.exware.gplatform.GPElement;
import de.exware.gplatform.element.GPCanvasElement;
import de.exware.gplatform.element.GPImageElement;
import de.exware.gplatform.element.GPInputElement;
import de.exware.gplatform.element.GPOptionElement;
import de.exware.gplatform.element.GPSelectElement;
import de.exware.gplatform.element.GPTextAreaElement;
import de.exware.gplatform.gwt.element.GwtGPCanvasElement;
import de.exware.gplatform.gwt.element.GwtGPImageElement;
import de.exware.gplatform.gwt.element.GwtGPInputElement;
import de.exware.gplatform.gwt.element.GwtGPOptionElement;
import de.exware.gplatform.gwt.element.GwtGPSelectElement;
import de.exware.gplatform.gwt.element.GwtGPTextAreaElement;

class GwtGPDocument implements de.exware.gplatform.GPDocument
{
    private Document doc;
    
    protected GwtGPDocument(Document doc)
    {
        this.doc = doc;
    }

    @Override
    public GPElement getElementById(String elementId)
    {
        Element el = doc.getElementById(elementId);
        return new GwtGPElement(el);
    }
    
    public static de.exware.gplatform.GPDocument get()
    {
        return new GwtGPDocument(Document.get());
    }

    @Override
    public GPElement createElement(String tagName)
    {
        Element el = doc.createElement(tagName);
        GPElement gel = new GwtGPElement(el);
        return gel;
    }

    @Override
    public GPElement getBody()
    {
        return new GwtGPElement(doc.getBody());
    }

    @Override
    public GPImageElement createImageElement()
    {
        ImageElement iel = doc.createImageElement();
        GPImageElement imgElement = new GwtGPImageElement(iel);
        return imgElement;
    }

    @Override
    public GPInputElement createCheckInputElement()
    {
        InputElement iel = doc.createCheckInputElement();
        GPInputElement element = new GwtGPInputElement(iel);
        return element;
    }

    @Override
    public GPSelectElement createSelectElement()
    {
        SelectElement iel = doc.createSelectElement();
        GPSelectElement element = new GwtGPSelectElement(iel);
        return element;
    }

    @Override
    public GPOptionElement createOptionElement()
    {
        OptionElement iel = doc.createOptionElement();
        GPOptionElement element = new GwtGPOptionElement(iel);
        return element;
    }

    @Override
    public GPInputElement createRadioInputElement(String name)
    {
        InputElement iel = doc.createRadioInputElement(name);
        GPInputElement element = new GwtGPInputElement(iel);
        return element;
    }

    @Override
    public GPTextAreaElement createTextAreaElement()
    {
        TextAreaElement iel = doc.createTextAreaElement();
        GPTextAreaElement element = new GwtGPTextAreaElement(iel);
        return element;
    }

    @Override
    public GPInputElement createTextInputElement()
    {
        InputElement iel = doc.createTextInputElement();
        GPInputElement element = new GwtGPInputElement(iel);
        return element;
    }

    @Override
    public GPInputElement createPasswordInputElement()
    {
        InputElement iel = doc.createPasswordInputElement();
        GPInputElement element = new GwtGPInputElement(iel);
        return element;
    }

    @Override
    public GPCanvasElement createCanvasElement()
    {
        CanvasElement iel = doc.createCanvasElement();
        GPCanvasElement element = new GwtGPCanvasElement(iel);
        return element;
    }
}
