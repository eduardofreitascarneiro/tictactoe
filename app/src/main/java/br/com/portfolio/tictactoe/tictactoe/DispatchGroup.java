package br.com.portfolio.tictactoe.tictactoe;

/**
 * DispatchGroup.
 */
public class DispatchGroup {

    // Variáveis
    private long mCount;

    private OnZeroedReferences mOnZeroedReferences;

    /**
     * Cria um novo DispatchGroup.
     */
    public DispatchGroup(OnZeroedReferences onZeroedReferences) {
        mCount = 0L;

        mOnZeroedReferences = onZeroedReferences;
    }

    /**
     * Incrementa a contagem.
     */
    public void increment() {
        mCount++;
    }

    /**
     * Decrementa a contagem.
     */
    public void decrement() {
        if (mCount > 0L) {
            mCount--;
        }

        if (mCount == 0L) {
            if (mOnZeroedReferences != null) {
                mOnZeroedReferences.onZeroedReferences();
            }
        }
    }

    /**
     * Interface para notificar zero referências.
     */
    public interface OnZeroedReferences {

        /**
         * Evento disparado quando a contagem for zero.
         */
        void onZeroedReferences();

    }

}
