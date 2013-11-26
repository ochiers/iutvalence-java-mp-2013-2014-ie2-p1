package fr.iutvalence.java.mp.BrickBreaker;

/**
 * @author soulierc
 *
 */
public interface UserPolling
{

        // TODO (fixed) finish writing comment
        /**
         * Function used to move to posX the game's paddle position.
         * @param posX The horizontal position to move the paddle.
         */
        public void moveThePaddle(int posX);
        
        public void pauseOrRestartGame();
}
