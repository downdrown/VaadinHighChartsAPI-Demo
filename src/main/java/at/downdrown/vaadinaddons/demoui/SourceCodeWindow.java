package at.downdrown.vaadinaddons.demoui;

import com.vaadin.ui.Window;
import org.vaadin.aceeditor.AceEditor;
import org.vaadin.aceeditor.AceMode;
import org.vaadin.aceeditor.AceTheme;

/**
 * Erstellt von Manfred Huber (02ub0j08) am 12. August 2015.<br />
 * Copyright &copy; HSWE Allg. Applikationen.<br />
 * Klasse: SourceCodeWindow.class<br />
 * Projekt: VaadinHighChartsAPI-Demo<br />
 * Package: at.downdrown.vaadinaddons.demoui<br />
 * <br>
 * <h1>SourceCodeWindow</h1>
 * <h3><code>at.downdrown.vaadinaddons.demoui.SourceCodeWindow</code></h3>
 * <p>Klassenbeschreibung</p>
 * <br>
 *
 * @author Manfred Huber<br />
 */
public class SourceCodeWindow extends Window {

    public SourceCodeWindow(String sourceCode) {

        this.center();
        this.setWidth(70, Unit.PERCENTAGE);
        this.setHeight(70, Unit.PERCENTAGE);

        AceEditor editor = new AceEditor();
        editor.setValue(sourceCode);
        editor.setMode(AceMode.java);
        editor.setTheme(AceTheme.twilight);
        editor.setSizeFull();

        this.setContent(editor);
    }
}
