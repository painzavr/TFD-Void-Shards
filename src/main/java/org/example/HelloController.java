package org.example;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import org.example.Place;
import org.example.Placement;
import org.example.Type;

import java.io.IOException;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class HelloController {
    private final double PLACE_SCALE_MODIFIER = 0.15;
    private final double LOCATION_SCALE_MODIFIER = 0.25;
    private final double OTHER_SCALE_MODIFIER = 0.12;
    boolean globalTrue = true;

    @FXML
    private CheckBox monomer;
    @FXML
    private CheckBox polymer;
    @FXML
    private CheckBox unorganic;
    @FXML
    private CheckBox organic;

    @FXML
    private CheckBox chillBox;
    @FXML
    private CheckBox electricityBox;
    @FXML
    private CheckBox fireBox;
    @FXML
    private CheckBox toxinBox;
    @FXML
    private CheckBox nonAttributeBox;

    @FXML
    private ChoiceBox<String> shardBox;

    @FXML
    private TableView<Placement> placeList;

    @FXML
    private ToggleButton mode;

    public ArrayList<Placement> placements = new ArrayList<>();
    ArrayList<Placement> toShow = new ArrayList<>();


    @FXML
    public void initialize() throws IOException {
        init();
    }
    protected void init() {
        double totalWidth = placeList.getPrefWidth();

        TableColumn<Placement, String> placeColumn = new TableColumn<>("Place");
        placeColumn.setCellValueFactory(new PropertyValueFactory<>("place"));
        placeColumn.setPrefWidth(totalWidth*0.18);

        TableColumn<Placement, String> locationColumn = new TableColumn<>("Location");
        locationColumn.setCellValueFactory(new PropertyValueFactory<>("location"));
        locationColumn.setPrefWidth(totalWidth*0.22);

        TableColumn<Placement, String> typeColumn = new TableColumn<>("Type");
        typeColumn.setCellValueFactory(new PropertyValueFactory<>("type"));
        typeColumn.setPrefWidth(totalWidth*0.15);

        TableColumn<Placement, Integer> monomerColumn = new TableColumn<>("Monomer");
        monomerColumn.setCellValueFactory(new PropertyValueFactory<>("monomer"));


        TableColumn<Placement, Integer> polymerColumn = new TableColumn<>("Polymer");
        polymerColumn.setCellValueFactory(new PropertyValueFactory<>("polymer"));

        TableColumn<Placement, Integer> organicColumn = new TableColumn<>("Organic");
        organicColumn.setCellValueFactory(new PropertyValueFactory<>("organic"));

        TableColumn<Placement, Integer> unorganicColumn = new TableColumn<>("Unorganic");
        unorganicColumn.setCellValueFactory(new PropertyValueFactory<>("unorganic"));

        placeList.getColumns().add(placeColumn);
        placeList.getColumns().add(locationColumn);
        placeList.getColumns().add(typeColumn);
        placeList.getColumns().add(monomerColumn);
        placeList.getColumns().add(polymerColumn);
        placeList.getColumns().add(organicColumn);
        placeList.getColumns().add(unorganicColumn);




        placements.add(new Placement(false, Place.Kingstone,"Большая площадь",Type.NonAttribute ,1,1,1,1));
        placements.add(new Placement(false, Place.SterileLands ,"Металлургический завод",Type.Chill ,1,1,1,1));
        placements.add(new Placement(false, Place.SterileLands ,"Склад",Type.Electricity ,6,0,2,0));
        placements.add(new Placement(false, Place.SterileLands ,"Запретная зона",Type.Fire ,1,1,1,1));
        placements.add(new Placement(false, Place.SterileLands ,"Камнепад",Type.Electricity ,6,1,0,0));
        placements.add(new Placement(false, Place.Vespers ,"Брошенный склад снабжения",Type.Fire ,0,6,0,2));
        placements.add(new Placement(false, Place.Vespers ,"Лунное Озеро",Type.NonAttribute ,1,1,1,1));
        placements.add(new Placement(false, Place.Vespers ,"Развалины",Type.Chill ,2,6,0,0));
        placements.add(new Placement(false, Place.Vespers ,"Бурелом",Type.NonAttribute ,1,1,1,1));
        placements.add(new Placement(false, Place.EchoSwamp ,"Покинутая зона",Type.Toxin ,0,2,6,0));
        placements.add(new Placement(false, Place.EchoSwamp ,"Обитель древних",Type.Toxin ,0,0,7,1));
        placements.add(new Placement(false, Place.EchoSwamp ,"Торфяное болото",Type.Fire ,2,0,0,6));
        placements.add(new Placement(false, Place.AgnaDesert ,"Пристанище бога",Type.NonAttribute ,1,1,1,1));
        placements.add(new Placement(false, Place.AgnaDesert ,"Место добычи",Type.Electricity ,7,1,0,0));
        placements.add(new Placement(false, Place.AgnaDesert ,"Хранилище",Type.Fire ,2,0,0,6));
        placements.add(new Placement(false, Place.AgnaDesert ,"Багряная пустошь",Type.Electricity ,0,0,2,6));
        placements.add(new Placement(false, Place.WhiteNightGulch ,"Инкубатор",Type.Fire ,0,0,2,6));
        placements.add(new Placement(false, Place.WhiteNightGulch ,"Котловина мертвой луны",Type.NonAttribute ,1,1,1,1));
        placements.add(new Placement(false, Place.WhiteNightGulch ,"Станция наблюдения",Type.Chill ,2,6,0,0));
        placements.add(new Placement(false, Place.WhiteNightGulch ,"Погрузочная база",Type.Toxin ,0,0,6,2));
        placements.add(new Placement(false, Place.WhiteNightGulch ,"Вершины",Type.Toxin ,0,2,6,0));
        placements.add(new Placement(false, Place.Hagios ,"Дюнная база",Type.Fire ,2,0,0,6));
        placements.add(new Placement(false, Place.Hagios ,"Треснувший монолит",Type.NonAttribute ,1,1,1,1));
        placements.add(new Placement(false, Place.Hagios ,"Оскверненная зона",Type.Fire ,0,0,1,7));
        placements.add(new Placement(false, Place.Fortress ,"Печь",Type.Chill ,1,7,0,0));
        placements.add(new Placement(false, Place.Fortress ,"Упавший ковчег",Type.Electricity ,7,0,1,0));
        placements.add(new Placement(false, Place.Fortress ,"Ледяная долина",Type.Chill ,0,6,0,2));

        placements.add(new Placement(true, Place.Kingstone,"Большая площадь",Type.NonAttribute ,3,3,3,3));
        placements.add(new Placement(true, Place.SterileLands ,"Металлургический завод",Type.Chill ,3,3,3,3));
        placements.add(new Placement(true, Place.SterileLands ,"Склад",Type.Electricity ,19,0,4,0));
        placements.add(new Placement(true, Place.SterileLands ,"Запретная зона",Type.Fire ,3,3,3,3));
        placements.add(new Placement(true, Place.SterileLands ,"Камнепад",Type.Electricity ,19,4,0,0));
        placements.add(new Placement(true, Place.Vespers ,"Брошенный склад снабжения",Type.Fire ,0,19,0,4));
        placements.add(new Placement(true, Place.Vespers ,"Лунное Озеро",Type.NonAttribute ,3,3,3,3));
        placements.add(new Placement(true, Place.Vespers ,"Развалины",Type.Chill ,6,17,0,0));
        placements.add(new Placement(true, Place.Vespers ,"Бурелом",Type.NonAttribute ,3,3,3,3));
        placements.add(new Placement(true, Place.EchoSwamp ,"Покинутая зона",Type.Toxin ,0,6,17,0));
        placements.add(new Placement(true, Place.EchoSwamp ,"Обитель древних",Type.Toxin ,0,0,20,3));
        placements.add(new Placement(true, Place.EchoSwamp ,"Торфяное болото",Type.Fire ,5,0,0,18));
        placements.add(new Placement(true, Place.AgnaDesert ,"Пристанище бога",Type.NonAttribute ,3,3,3,3));
        placements.add(new Placement(true, Place.AgnaDesert ,"Место добычи",Type.Electricity ,20,3,0,0));
        placements.add(new Placement(true, Place.AgnaDesert ,"Хранилище",Type.Fire ,4,0,0,19));
        placements.add(new Placement(true, Place.AgnaDesert ,"Багряная пустошь",Type.Electricity ,0,0,4,20));
        placements.add(new Placement(true, Place.WhiteNightGulch ,"Инкубатор",Type.Fire ,0,0,4,19));
        placements.add(new Placement(true, Place.WhiteNightGulch ,"Котловина мертвой луны",Type.NonAttribute ,3,3,3,3));
        placements.add(new Placement(true, Place.WhiteNightGulch ,"Станция наблюдения",Type.Chill ,4,19,0,0));
        placements.add(new Placement(true, Place.WhiteNightGulch ,"Погрузочная база",Type.Toxin ,0,0,20,3));
        placements.add(new Placement(true, Place.WhiteNightGulch ,"Вершины",Type.Toxin ,0,7,16,0));
        placements.add(new Placement(true, Place.Hagios ,"Дюнная база",Type.Fire ,6,0,0,17));
        placements.add(new Placement(true, Place.Hagios ,"Треснувший монолит",Type.NonAttribute ,3,3,3,3));
        placements.add(new Placement(true, Place.Hagios ,"Оскверненная зона",Type.Fire ,0,0,5,18));
        placements.add(new Placement(true, Place.Fortress ,"Печь",Type.Chill ,3,20,0,0));
        placements.add(new Placement(true, Place.Fortress ,"Упавший ковчег",Type.Electricity ,17,0,6,0));
        placements.add(new Placement(true, Place.Fortress ,"Ледяная долина", Type.Chill ,0,19,0,4));

        shardBox.getItems().addAll(new String[]{"Monomer", "Polymer", "Unorganic", "Organic"});
    }
    public void search(){
        boolean m = monomer.isSelected();
        boolean p = polymer.isSelected();
        boolean u = unorganic.isSelected();
        boolean o = organic.isSelected();
        boolean sb = shardBox.isVisible();
        toShow = new ArrayList<>(placements);
        if(m || p || u || o){
            shardFiltering(m,p,u,o);
        }
        if(sb){
            priorityFiltering();
        }
        boolean c = chillBox.isSelected();
        boolean e = electricityBox.isSelected();
        boolean f = fireBox.isSelected();
        boolean t = toxinBox.isSelected();
        boolean n = nonAttributeBox.isSelected();
        if(c||e||f||t||n){
            elementalFiltering(c,e,f,t,n);
        }
        modeFiltering();
        placeList.getItems().clear();
        placeList.getItems().addAll(toShow);
    }

    private void elementalFiltering(boolean c, boolean e, boolean f, boolean t, boolean n){
        System.out.println("Chill - " + c + " - " + e + " - " + f + " - " + t + " - " + n);
        toShow = toShow.stream()
                .filter(placement -> elementalCondition(placement.getType() ,c,e,f,t,n))
                .collect(Collectors.toCollection(ArrayList::new));
        System.out.println("norm");
        placeList.getItems().clear();
        placeList.getItems().addAll(toShow);
    }

    public void setAllActive(){
        if(globalTrue){
            chillBox.setSelected(true);
            electricityBox.setSelected(true);
            toxinBox.setSelected(true);
            fireBox.setSelected(true);
            nonAttributeBox.setSelected(true);
        }else{
            chillBox.setSelected(false);
            electricityBox.setSelected(false);
            toxinBox.setSelected(false);
            fireBox.setSelected(false);
            nonAttributeBox.setSelected(false);
        }
        globalTrue = !globalTrue;
    }
    private boolean elementalCondition(Type type, boolean c, boolean e, boolean f, boolean t, boolean n){
        switch (type){
            case Chill:
                return c;
            case Fire:
                return f;
            case Electricity:
                return e;
            case Toxin:
                return t;
            case NonAttribute:
                return n;
        }
        return true;
    }
    private void modeFiltering(){
        toShow = toShow.stream()
                .filter(placement -> placement.getHardMode() == mode.isSelected())
                .collect(Collectors.toCollection(ArrayList::new));

    }
    private void priorityFiltering() {
        String priority = shardBox.getSelectionModel().getSelectedItem();
        System.out.println(priority);
        switch (priority) {
            case "Monomer":
                toShow = toShow.stream()
                        .filter(placement -> numberCondition(placement.getMonomer(), placement.getPolymer(), placement.getOrganic(), placement.getUnorganic()))
                        .collect(Collectors.toCollection(ArrayList::new));
                break;
            case "Polymer":
                toShow = toShow.stream()
                        .filter(placement -> numberCondition(placement.getPolymer(), placement.getMonomer(), placement.getOrganic(), placement.getUnorganic()))
                        .collect(Collectors.toCollection(ArrayList::new));
                break;
            case "Unorganic":
                toShow = toShow.stream()
                        .filter(placement -> numberCondition(placement.getUnorganic(), placement.getPolymer(), placement.getOrganic(), placement.getMonomer()))
                        .collect(Collectors.toCollection(ArrayList::new));
                break;
            case "Organic":
                toShow = toShow.stream()
                        .filter(placement -> numberCondition(placement.getOrganic(), placement.getPolymer(), placement.getMonomer(), placement.getUnorganic()))
                        .collect(Collectors.toCollection(ArrayList::new));
                break;
        }
        placeList.getItems().clear();
        placeList.getItems().addAll(toShow);
    }
    private boolean numberCondition(int main, int first, int second, int third){
        return (main > first && main > second && main > third);
    }

    public void shardChange(){
        shardBox.setVisible(!shardBox.isVisible());
        updateShardBox();
    }

    public void updateShardBox() {
        shardBox.getItems().clear();
        if(monomer.isSelected()){
            shardBox.getItems().add("Monomer");
        }
        if(polymer.isSelected()){
            shardBox.getItems().add("Polymer");
        }
        if(unorganic.isSelected()){
            shardBox.getItems().add("Unorganic");
        }
        if(organic.isSelected()){
            shardBox.getItems().add("Organic");
        }
    }

    private void shardFiltering(boolean m, boolean p, boolean u, boolean o) {

        if(m){
            toShow = toShow.stream()
                    .filter(placement -> placement.getMonomer()>0)
                    .collect(Collectors.toCollection(ArrayList::new));
        }
        if(p){
            toShow = toShow.stream()
                    .filter(placement -> placement.getPolymer()>0)
                    .collect(Collectors.toCollection(ArrayList::new));
        }
        if(u){
            toShow = toShow.stream()
                    .filter(placement -> placement.getUnorganic()>0)
                    .collect(Collectors.toCollection(ArrayList::new));
        }
        if(o){
            toShow = toShow.stream()
                    .filter(placement -> placement.getOrganic()>0)
                    .collect(Collectors.toCollection(ArrayList::new));
        }
        placeList.getItems().clear();
        placeList.getItems().addAll(toShow);
    }

}