package fr.iutvalence.java.mp.BrickBreaker;

// TODO (fix) finish writing comment
/**
 * @author soulierc
 *
 */
// TODO (fix) you should rename this interface since it suggests that it enables
// to poll the user. Game implements this interface and never polls the user but is
// rather notified by him...
public interface UserPolling
{
        /**
         * Function used to move to posX the game's paddle position.
         * @param posX The horizontal position to move the paddle.
         */
        public void moveThePaddle(int posX);
        
        // TODO (fix) write comment
        public void pauseOrRestartGame();
}
