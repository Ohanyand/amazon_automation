public class Product {

    private String _name;
    private float _price;

    public Product(String name, float price){
        this._name = name;
        this._price = price;

    }
    public String GetName(){
        return _name;
    }

    public float GetPrice(){
        return _price;
    }
}
