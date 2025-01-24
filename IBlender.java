/*HOJA DE TRABAJO 1
*ANTONY SAZ 24710, LAZARO DIAZ 24713, JAVIER CHAVEZ 23132
*
*
 * Interfaz intercambiable con los metodos de la licuadora
 */
public interface IBlender {
    void SpeedUp();
    boolean IsFull();
    void Fill();
    void Empty();
    void SpeedDown();
    int GetSpeed();
    
}
