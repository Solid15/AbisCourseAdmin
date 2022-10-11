package be.abis.coffee;

public class Cup {

    private Fillable fillable;

    public Cup() {
    }

    public Fillable getFillable() {
        if (fillable != null) {
            return fillable;
        } else {
            return new Fillable() {
                @Override
                public void drink(Person person, Fillable fillable) {
                    System.out.println(person.getName() + ": There is nothing to drink here!!!");
                }
            };
        }
    }

    public void setFillable(Fillable fillable) {
        this.fillable = fillable;
    }
}
