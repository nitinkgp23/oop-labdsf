
public class test {
    public static void main(String[] args) {
        ObservableList<Pair<String,Double>> data = FXCollections.observableArrayList();
        Pair a = new Pair<>("b", 1.2);
        data.add(a);
        a = new Pair<>("a", 2.1);
        data.add(a);
        FXCollections.sort(data, (Pair<String, Double> p1, Pair<String, Double> p2) -> p1.getValue().compareTo(p2.getValue()));
        FXCollections.reverse(data);
        for (int i = 0; i<data.size();i++){
            System.out.println(data.get(i));
        }
    }
}
