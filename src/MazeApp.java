import javax.swing.SwingUtilities;

import controllers.MazeController;
import views.MazeFrame;

public class MazeApp {
    public static void main(String[] args) throws Exception {
        SwingUtilities.invokeLater(() -> {
            // Crear la vista principal
            MazeFrame view = new MazeFrame();
            
            // Crear el controlador y conectar la vista
            MazeController controller = new MazeController(view);
            
            // Iniciar la aplicación
            view.setVisible(true);
        });
       
    }
}
