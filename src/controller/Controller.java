package controller;

import view.Canvas;
import view.gui.CheckBox;
import view.gui.Toolbar;

import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.AbstractAction;
import javax.swing.SwingUtilities;
import javax.swing.event.PopupMenuEvent;
import javax.swing.event.PopupMenuListener;

import static java.awt.event.KeyEvent.VK_C;
import static javax.swing.JComponent.WHEN_IN_FOCUSED_WINDOW;
import static javax.swing.KeyStroke.getKeyStroke;

public class Controller {

    private static final List<String> SHAPE_NAMES = List.of("Tvar A", "Tvar B", "Tvar C", "Kubika");

    private final Canvas canvas;
    private final Toolbar toolbar;

    /* -=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=- Constructors -=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-= */

    public Controller(Canvas canvas, Toolbar toolbar) {
        this.canvas = canvas;
        this.toolbar = toolbar;
    }

    /* -=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=- Initialization -=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-= */

    public void init() {
        registerShapeOptions();
        registerToolbarActions();
        registerShapesPopupListener();
        registerInputListeners();
        registerResetShortcut();
        render();
    }

    /* -=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=- Actions -=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=- */

    private void showShapesMenu() {
        toolbar.getShapesPopup().show(
                toolbar.getShapesButton(), 0,
                toolbar.getShapesButton().getHeight()
        );
    }

    private void restoreToolbarFocus() {
        SwingUtilities.invokeLater(toolbar::requestFocusInWindow);
    }

    private void registerShapeOptions() {
        for (String name : SHAPE_NAMES) {
            toolbar.registerShapeOption(name);
        }
    }

    private void registerResetShortcut() {
        canvas.getInputMap(WHEN_IN_FOCUSED_WINDOW).put(getKeyStroke(VK_C, 0), "resetScene");
        canvas.getActionMap().put("resetScene", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resetScene();
            }
        });
    }


    private void registerToolbarActions() {
        toolbar.getResetButton().addActionListener(_ -> resetScene());
        toolbar.getShapesButton().addActionListener(_ -> showShapesMenu());
        toolbar.getCameraButton().addActionListener(e -> {
            // TODO (cvičení 10): Přepínejte mezi perspektivní (Mat4PerspRH) a pravoúhlou (Mat4OrthoRH) projekcí.
            // TODO (cvičení 10): Nastavte parametry projekce podle rozměrů canvasu a aktualizujte popisek tlačítka.
            render();
        });

        toolbar.getAxesCheckBox().addActionListener(e -> {
            // TODO (cvičení 10): Podle stavu checkboxu zapínejte nebo vypínejte zobrazení souřadnicových os.
            // TODO (cvičení 10): Osy vykreslujte v barvách X (červená), Y (zelená) a Z (modrá).
            render();
        });

        for (CheckBox option : toolbar.getShapeOptions().values()) {
            option.addActionListener(e -> {
                // TODO (cvičení 10): Podle stavu checkboxu zobrazte nebo skryjte odpovídající těleso či kubiku.
                render();
            });
        }
    }

    private void registerInputListeners() {
        canvas.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                // TODO (cvičení 10): Implementujte pohyb kamery pomocí kláves W/S/A/D (vpřed, vzad, vlevo, vpravo).
                // TODO (cvičení 10): Klávesami Q/E otáčejte kameru doleva a doprava změnou azimutu.
                // TODO (cvičení 10): Klávesami SHIFT/CTRL pohybujte kamerou nahoru a dolů.
                // TODO (cvičení 10): Umožněte posunutí, otočení a změnu měřítka vybraného tělesa.
                // BONUS (cvičení 10): Přidejte přepínání mezi globálními a lokálními transformacemi.
            }

            @Override
            public void keyReleased(KeyEvent e) {
                // TODO (cvičení 10): Ukončete pohyb kamery při uvolnění příslušné klávesy, pokud používáte průběžné ovládání.
            }
        });

        MouseAdapter mouse = new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // TODO (cvičení 10): Umožněte výběr tělesa kliknutím a aktivní těleso zvýrazněte žlutou barvou.
            }

            @Override
            public void mousePressed(MouseEvent e) {
                // TODO (cvičení 10): Uložte počáteční polohu myši pro následný výpočet jejího pohybu.
                canvas.requestFocusInWindow();
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                // TODO (cvičení 10): Ukončete případné tažení myší.
            }

            @Override
            public void mouseDragged(MouseEvent e) {
                // TODO (cvičení 10): Vypočítejte změnu polohy myši a upravte azimut a zenit kamery.
                // TODO (cvičení 10): Aktualizujte poslední polohu myši a znovu vykreslete scénu.
                // BONUS (cvičení 10): Umožněte transformaci aktivního tělesa tažením za gizmo.
            }
        };

        canvas.addMouseListener(mouse);
        canvas.addMouseMotionListener(mouse);
    }

    private void registerShapesPopupListener() {
        toolbar.getShapesPopup().addPopupMenuListener(new PopupMenuListener() {
            @Override
            public void popupMenuCanceled(PopupMenuEvent e) {
                restoreToolbarFocus();
            }

            @Override
            public void popupMenuWillBecomeVisible(PopupMenuEvent e) {

            }

            @Override
            public void popupMenuWillBecomeInvisible(PopupMenuEvent e) {
                restoreToolbarFocus();
            }
        });
    }

    /* -=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-= Rendering -=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-= */

    private void render() {
        canvas.clear();
        // TODO (cvičení 9): Pomocí meshRenderer.render() vykreslete tělesa.

        // TODO (cvičení 10): Rozšiřte scénu alespoň o tři různá tělesa z každé skupiny a respektujte jejich viditelnost.
        // TODO (cvičení 10): Aplikujte modelovací, pohledovou a projekční matici. Po perspektivním dělení převeďte vrcholy do NDC.
        // TODO (cvičení 10): Implementujte přísné ořezávání hran v homogenních souřadnicích před perspektivním dělením.
        // TODO (cvičení 10): Podle stavu checkboxu vykreslete osy X (červená), Y (zelená) a Z (modrá).

        // TODO (cvičení 11): Vytvořte Fergusonovu, Bézierovu a Coonsovu kubiku pomocí třídy Cubic a čtyř řídicích bodů.
        // TODO (cvičení 11): Vzorkujte křivky pomocí compute(t) a sousední body propojte úsečkami.
        // TODO (cvičení 11): Vytvořte bikubickou plochu ze 16 řídicích bodů a vykreslete její síť pomocí compute(u, v).

        // BONUS (cvičení 10): Zobrazte ve středu vybraného tělesa gizmo pro jeho posouvání, otáčení a změnu měřítka.

        canvas.repaint();
    }

    private void resetScene() {
        toolbar.getShapeOptions().values().forEach(option -> option.setSelected(false));
        toolbar.getAxesCheckBox().setSelected(false);

        // TODO (cvičení 10): Obnovte výchozí kameru, projekci a transformace těles. Zrušte aktivní výběr.

        render();
    }

}
