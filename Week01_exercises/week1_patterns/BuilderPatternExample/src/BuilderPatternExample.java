public class BuilderPatternExample {
    // Computer class
    public static class Computer {
        // Attributes of the Computer
        private String CPU;
        private String RAM;
        private String storage;
        private String GPU;
        private String motherboard;

        // Private constructor to take Builder as parameter
        private Computer(Builder builder) {
            this.CPU = builder.CPU;
            this.RAM = builder.RAM;
            this.storage = builder.storage;
            this.GPU = builder.GPU;
            this.motherboard = builder.motherboard;
        }

        // Getters for Computer attributes (optional)
        public String getCPU() {
            return CPU;
        }

        public String getRAM() {
            return RAM;
        }

        public String getStorage() {
            return storage;
        }

        public String getGPU() {
            return GPU;
        }

        public String getMotherboard() {
            return motherboard;
        }

        // Static nested Builder class
        public static class Builder {
            private String CPU;
            private String RAM;
            private String storage;
            private String GPU;
            private String motherboard;

            // Methods to set each attribute
            public Builder setCPU(String CPU) {
                this.CPU = CPU;
                return this;
            }

            public Builder setRAM(String RAM) {
                this.RAM = RAM;
                return this;
            }

            public Builder setStorage(String storage) {
                this.storage = storage;
                return this;
            }

            public Builder setGPU(String GPU) {
                this.GPU = GPU;
                return this;
            }

            public Builder setMotherboard(String motherboard) {
                this.motherboard = motherboard;
                return this;
            }

            // Build method to create Computer instance
            public Computer build() {
                return new Computer(this);
            }
        }

        @Override
        public String toString() {
            return "Computer [CPU=" + CPU + ", RAM=" + RAM + ", storage=" + storage + ", GPU=" + GPU + ", motherboard=" + motherboard + "]";
        }
    }

    // Test class
    public static void main(String[] args) {
        // Create different configurations of Computer using the Builder pattern
        Computer gamingPC = new Computer.Builder()
            .setCPU("Intel Core i9")
            .setRAM("32GB")
            .setStorage("1TB SSD")
            .setGPU("NVIDIA GeForce RTX 3080")
            .setMotherboard("ASUS ROG Maximus")
            .build();

        Computer officePC = new Computer.Builder()
            .setCPU("Intel Core i5")
            .setRAM("16GB")
            .setStorage("512GB SSD")
            .build();

        Computer budgetPC = new Computer.Builder()
            .setCPU("AMD Ryzen 3")
            .setRAM("8GB")
            .setStorage("256GB SSD")
            .build();

        // Print the configurations
        System.out.println(gamingPC);
        System.out.println(officePC);
        System.out.println(budgetPC);
    }
}
