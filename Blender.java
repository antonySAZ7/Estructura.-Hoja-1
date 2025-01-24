/*HOJA DE TRABAJO 1
*ANTONY SAZ 24710, LAZARO DIAZ 24713, JAVIER CHAVEZ 23132
*
*
 * Clase que implementa la interfaz de la licuadora
 */
public class Blender implements IBlender {
    //Atributos
    private int speed;
    private boolean isFull;

    //Constructor
    public Blender(){
        this.speed = 0;
        this.isFull = false;
    }
    //Metodos
    @Override
    /*
     * Aumenta en 1 la velocidad de la licuadora
     */
    public void SpeedUp(){
        if(!isFull){
            System.out.println("La licuadora esta vacia");
            return;
        }
        if(speed < 10){
            speed++;
            System.out.println("velocidad aumentada a : " + speed);
        }else{
            System.out.println("La velocidad de la licuadora esta en su maximo nivel, 10");
        }
    }
    @Override
    /*
     * Disminuye en 1 la velocidad de la licuadora
     */
    public void SpeedDown(){
        if(!isFull){
            System.out.println("La licuadora esta vacia");
            return;
        }
        if(speed > 0){
            speed =  speed - 1;
            System.out.println("La velocidad bajo a : "+ speed);
        }else{
            System.out.println("La velocidad de la licuadora esta en su minimo nivel, 0");
        }
    }
    @Override
    /*
     * Devuelve si la licuadora esta llena
     */
    public boolean IsFull(){
        return isFull;
    }
    @Override
    /*
     * Llena la licuadora si esta vacia
     */
   public void Fill(){
    if(isFull){
        System.out.println("La licuadora esta llena");
    }else{
        isFull = true;
        System.out.println("Ahora la licuadora esta llena");
    }
   } 
   @Override
   /*
    * vacia la licuadora si esta llena
    */
   public void Empty(){
    if(!isFull){
        System.out.println("La licuadora esta vacia");
        return;
    }else{
    isFull= false;
    System.out.println("La licuadora esta vacia");
    }
   }
   @Override
   /*
    * Devuelve la velocidad actual de la licuadora
    */
   public int GetSpeed() {
    return speed;
    }
}
