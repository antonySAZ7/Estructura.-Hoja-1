public class Blender implements IBlender {

    private int speed;
    private boolean isFull;

    public Blender(){
        this.speed = 0;
    }

    public void SpeedUp(){
        if(!isFull){
            System.out.println("La licuadora esta vacia");
            return;
        }
        if(speed < 10){
            speed++;
            System.out.println("velocidad aumentada a : " + speed);
        }else{
            System.out.println("La velocidad de la licuadara esta en su maximo nivel, 10");
        }
    }

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
    
    public boolean IsFull(){
        return isFull;
    }

   public void Fill(){
    if(isFull){
        System.out.println("La licuadora esta llena");
    }else{
        isFull = true;
        System.out.println("Ahora la licuadora esta llena");
    }
   } 

   public void Empty(){
    if(!isFull){
        System.out.println("La licuadora esta vacia");
        return;
    }
    isFull= false;
    System.out.println("La licuadira esta vacia");
   }

   public int GetSpeed() {
    return speed;
}


}
