package one.jpro.hellojpro;

import com.jpro.webapi.JProApplication;
import com.jpro.webapi.WebAPI;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.layout.*;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Hello JPro FXML controller.
 *
 * @author Florian Kirmaier
 */
public class HelloJProFXMLController implements Initializable {

    @FXML
    protected VBox root;

    protected JProApplication jproApplication;

    private static final String PRESIGNED_URL =
            "https://mmione-tests.s3.eu-west-3.amazonaws.com/global/mmi_order/rayons/jus.jpg?response-content-disposition=inline&X-Amz-Security-Token=IQoJb3JpZ2luX2VjEOD%2F%2F%2F%2F%2F%2F%2F%2F%2F%2FwEaCWV1LXdlc3QtMyJIMEYCIQCDQU2jdpZWG4CfZtckW0FR1h0a%2FBtwrtlTSVL6pGcY0gIhAIkNq73Mxvek8zm%2FLd%2B6CAcsfIIcftClBsUhrq9DWWksKoUDCFkQARoMNzg2NTM3NjE5MjQ4Igwr9Vmz1CzTwg1s5GMq4gKURSwxfeuXnkOfA2RR50g%2BDxa0dVQCqlgW63LneiW7PaXWOdDrGcg4XsMNZ%2Fe2kkDT0nSSgIC68JCgUj03QcndN%2B0CBLpAuX7RXmSwqCzQC0xUG%2FZ1PZacQUL2uHLjkVpDuoRGXfZAqKebSJRVpZX2%2FCteSJSY8hXe2A8v8E4EhDcFIA4UKZmt%2BYpmM%2F2Wli56MTIaTGVJSi5Ek8QQ992MqL6EQwsbE7VVAar%2FWdSiEdHO96sS43BrVVFNDg%2FzI1Y%2FpVQzOiQug0UjPTaLBHWcxuyO4kRnkIXuvflaDkWxStwz8bl11ln%2F14wVjDy3OJon%2F2QjyUfKkyac%2FXFItTm35aqlseWJGzc%2BlNvQKbg31799pb2a6z%2BLovh0qlya9%2B7bjc9tgPsox2Mm4C0Rk%2B62DtE2sq0UsvllHtDBh4G5gfNC%2Fa5DcG0FGkUKWKH3zlwY%2BjBtwRIEXFEdyFwRKTMWO7Ywq9nqqwY6sgKUW6qEIMNd%2BZBKLsY6ROGgMLgq3xua%2F6JJPHNjVO9R41%2BPXhy6OBXBma35eHs43Jk7cfudm26w4unCP1vLKf%2BuDjSCofQigPPyWNRY8Sq4h2%2Fpkw82EKBHkzTJPfp8WlKCpPS0kffiPX6oPZtEMTiiTDtnU6U1ABFtLgUbD0FYRQ8monZpuYS8q4wugHWpWOUHoSYj%2Ffzus1kQXcYEcSkn%2FXJBN%2F6L2hV9kVmmPO%2BMpRDvfzG39buvwaZNquR1EdW9EJ82U57Uyiu6IKlhDfC3J4TmCdH29Xtyx2Hq9wN95wS%2FSCcNJwbEPc15sl3TyWfGrgpTv66IbJTP3tEJYGOav7OUNxhTuRcyFoYs8Fd4nas%2F5%2B0LeL7a5LagwWFIu3%2F0ddXyOfYOb%2FuoDdh7fLrhVKk%3D&X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Date=20231214T143715Z&X-Amz-SignedHeaders=host&X-Amz-Expires=43200&X-Amz-Credential=ASIA3OIKLT4YBS3KBUP7%2F20231214%2Feu-west-3%2Fs3%2Faws4_request&X-Amz-Signature=742399e50744ec08061f3b489c52aef2d7e505e6e9f22e31e94e0333f6b14d2e";

    @Override
    public void initialize(final URL location, final ResourceBundle resources) {
    }

    protected void init(final JProApplication jproApplication) {
        this.jproApplication = jproApplication;

    }

    @FXML
    private void onCreateVirtualImageWorking(@SuppressWarnings("unused") final ActionEvent actionEvent) {
        System.out.println("Create virtual image that work");
        final Image image = WebAPI.createVirtualImage(PRESIGNED_URL, 400, 179);
        setBackgroundImage(image);
    }

    @FXML
    private void onCreateVirtualImageNotWorking(@SuppressWarnings("unused") final ActionEvent actionEvent) {
        System.out.println("Create virtual image that doesn't work");

        final Image image =  WebAPI.createVirtualImage(PRESIGNED_URL, 400, 179, false);
        setBackgroundImage(image);

    }

    @FXML
    private void onCreateVirtualImageNotWorkingWithProxy(@SuppressWarnings("unused") final ActionEvent actionEvent) {
        System.out.println("Create virtual image that doesn't work with proxy");

        final Image image =  WebAPI.createVirtualImage(PRESIGNED_URL, 400, 179, true);
        setBackgroundImage(image);
    }

    private void setBackgroundImage(final Image image){
        // Taille de l'image
        final BackgroundSize backgroundSize = new BackgroundSize(
                BackgroundSize.AUTO,
                BackgroundSize.AUTO,
                false,
                false,
                false,
                true);

        // Création de l'image background
        final BackgroundImage backgroundImage = new BackgroundImage(
                image,
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER,
                backgroundSize
        );

        root.setBackground(new Background(backgroundImage));
    }

}
