package be.abis.coffee;

public interface Fillable {

    void drink(Person person, Fillable fillable);

    default void destroyItself(Fillable fillable) {
        fillable = null;
        System.out.println("");
    }


}
