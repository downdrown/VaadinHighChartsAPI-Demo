package at.downdrown.vaadinaddons.demoui;

import at.downdrown.vaadinaddons.demoui.views.Views;
import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.ui.ComponentContainer;
import com.vaadin.ui.UI;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Erstellt von Manfred Huber (downdrown) am 22. März 2015.<br>
 * Copyright &copy; Manfred Huber.<br>
 * Klasse: BaseNavigator.class<br>
 * Projekt: VaadinHighChartsAPI-Demo<br>
 * Package: at.downdrown.vaadinaddons.demoui<br>
 * <br>
 * <h1>BaseNavigator</h1>
 * <h3><code>at.downdrown.vaadinaddons.demoui.BaseNavigator</code></h3>
 * <br>
 *
 * @author Manfred Huber<br>
 */
public class BaseNavigator extends Navigator {

    /**
     * Es werden ganz automatisch beim Instanziieren des Navigators alle
     * vorhandenen View Klassen aus der {@link Views} ENUM im Navigator registriert.
     *
     * @param ui
     * @param container
     */
    public BaseNavigator(UI ui, ComponentContainer container) {
        super(ui, container);
        for (Views v : Views.values()) {
            super.addView(v.getBezeichnung(), v.getView());
        }

        this.addViewChangeListener(new ViewChangeListener() {
            @Override
            public boolean beforeViewChange(ViewChangeEvent event) {
                return true;
            }

            @Override
            public void afterViewChange(ViewChangeEvent event) {
                if (event.getOldView() == null) {
//                    LoggerFactory.info("Benutzer " + UI.getCurrent().getSession().getAttribute(Benutzer.class).getBenutzername() + " hat sich angemeldet.");
                } else {
//                    LoggerFactory.info("Benutzer " + UI.getCurrent().getSession().getAttribute(Benutzer.class).getBenutzername() + " hat von " + event.getOldView().getClass().getSimpleName() + " nach " + event.getNewView().getClass().getSimpleName() + " navigiert.");
                }
            }
        });
    }

    public void navigateTo(Views viewToNavigateTo) {
        super.navigateTo(viewToNavigateTo.getBezeichnung());
    }

    public void navigateTo(final Views viewToNavigateTo, int delayInSeconds) {
        new Timer(false).schedule(new TimerTask() {
            @Override
            public void run() {
                navigateTo(viewToNavigateTo);
            }
        }, delayInSeconds * 1000);

    }

    @Deprecated
    @Override
    protected void navigateTo(View view, String viewName, String parameters) {
        super.navigateTo(view, viewName, parameters);
    }

    @Deprecated
    @Override
    public void navigateTo(String navigationState) {
        super.navigateTo(navigationState);
    }
}
