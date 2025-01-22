/*
 * Interfaz para pruebas de funcionamiento de intercambios
 */
public interface IblenderAlternate{
    void SpeedUp();
    boolean IsFull();
    void Fill();
    void Empty();
    void SpeedDown();
    int GetSpeed();
}
