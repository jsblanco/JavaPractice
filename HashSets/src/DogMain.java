public class DogMain {


    public static void main(String[] args) {

    Cavalier atila = new Cavalier("Atila");
    Dog dogAtila = new Dog("Atila");

    System.out.println(dogAtila.equals(atila));
    // Dará true porque Cavalier es una instancia de Dog

    System.out.println(atila.equals(dogAtila));
    // Dará false porque Dog no es una instancia de Cavalier
    // Tras comentar el override de equals en Cavalier, volverá a dar true
    // Marcar un método como final hará que no se pueda hacer override en subclases y así evitar estos problemas.
    }

}
