public class Guest {
        private final String name;
        private String email;
        private String phoneNum;
        private String address;

        public Guest (String name, String email, String phoneNum, String address) {
            this.name = name;
            this.email = email;
            this.phoneNum = phoneNum;
            this.address = address;
        }

        public String getName() {
            return name;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail (String email) {
            this.email = email;
        }

        public String getPhoneNum() {
            return phoneNum;
        }

        public void setPhoneNum (String phoneNum) {
            this.phoneNum = phoneNum;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress (String address) {
            this.address = address;
        }


}
