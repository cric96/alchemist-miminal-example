package it.unibo.alchemist.models.actions;

import it.unibo.alchemist.model.*;
import it.unibo.alchemist.model.actions.AbstractAction;


public class MoveRight<P extends Position<P>> extends AbstractAction<Integer> {
    private final Node<Integer> node; // implicit value

    private final Environment<Integer, P> environment; // implicit value

    public MoveRight(Node<Integer> node, Environment<Integer, P> environment) {
        super(node);
        this.node = node;
        this.environment = environment;
    }

    @Override
    public Action<Integer> cloneAction(Node<Integer> node, Reaction<Integer> reaction) {
        return new MoveRight(node,  environment);
    }

    @Override
    public void execute() {
       var currentPosition = environment.getPosition(node);
       var newPosition = currentPosition.plus(environment.makePosition(1, 0).getCoordinates());
       environment.moveNodeToPosition(node, newPosition);
    }

    @Override
    public Context getContext() {
        return Context.NEIGHBORHOOD; // it is local because it changes only the local molecule
    }
}
