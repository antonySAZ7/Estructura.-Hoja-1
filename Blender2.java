/*
 * Clase para pruebas de funcionamiento de intercambio
 */
public class Blender2 implements IBlender {
    //Atributos
    private int speed;
    private boolean isFull;

    //Constructor
    public Blender2(){
        this.speed = 7;
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
            System.out.println("la licuadora ya esta a maxima potencia");
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
            System.out.println("La licuadora ya esta sin potencia");
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
        System.out.println("licuadora llenada exitosamente");
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
    System.out.println("licuadora vaciada exitosamente");
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
