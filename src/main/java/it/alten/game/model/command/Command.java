package it.alten.game.model.command;

import it.alten.game.controller.GameController;
import it.alten.game.service.ConfigBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;


@Component
public abstract class Command {

    ApplicationContext context = new AnnotationConfigApplicationContext(ConfigBean.class);
    private GameController gameController = context.getBean(GameController.class);
    @Autowired
    protected Command(){

    }

    public GameController getGameController() {
        return gameController;
    }

    @Autowired
    public void setGameController(GameController gameController) {
        this.gameController = gameController;
    }

    public abstract void execute();

}
