import java.util.Date;

public class PlantOOPobject {
    private int plantId;
    private String name;
    private String species;
    private int quantity;
    private Date purchaseDate;
    private String healthStatus;

    
    public Plant(int plantId, String name, String species, int quantity, Date purchaseDate) {
        this.plantId = plantId;
        this.name = name;
        this.species = species;
        this.quantity = quantity;
        this.purchaseDate = purchaseDate;
        this.healthStatus = "Healthy"; 
    }

    public int getPlantId() {
        return plantId;
    }

    public String getName() {
        return name;
    }

    public String getSpecies() {
        return species;
    }

    public int getQuantity() {
        return quantity;
    }

    public Date getPurchaseDate() {
        return purchaseDate;
    }

    public String getHealthStatus() {
        return healthStatus;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void updateHealthStatus(String status) {
        this.healthStatus = status;
    }
}
