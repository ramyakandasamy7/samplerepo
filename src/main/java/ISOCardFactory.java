public class ISOCardFactory implements AbstractCardFactory {
    public typeofCard getCard(String cardNumber) {
        if ((cardNumber.length() == 13 || cardNumber.length() == 16)  && cardNumber.charAt(0) =='4')
        {
            return new Visa();
        }
        if ((cardNumber.length() == 16) && cardNumber.charAt(0)== '5' && (cardNumber.charAt(1) == '3' || cardNumber.charAt(1)=='4' || cardNumber.charAt(1) =='5')) {
            return new Mastercard();
        }
        if ((cardNumber.charAt(0)=='3') && (cardNumber.length()==15) &&  ((cardNumber.charAt(1)=='7')|| (cardNumber.charAt(1)=='4'))) {
            return  new AmericanExpress();
        }
        if ((cardNumber.length() == 16 ) && (cardNumber.substring(0,4).contentEquals("6011"))) {
            return new Discover();
        }
        else {
        return null;
        }
    }

}
