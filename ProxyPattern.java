package proxy;
interface Image{
    void show();
}
class RealImage implements Image{
    String fileName;
    public RealImage(String fileName){
        this.fileName=fileName;
    }
    public void show(){
        System.out.println(fileName);
    }
}

 class ProxyImage implements Image {
    RealImage realImage;
    String fileName;
    String userRole;
    public ProxyImage(String fileName,String userRole) {
        this.userRole = userRole;
        this.fileName=fileName;
    }

        public void show(){
           if(!"ADMIN".equals(userRole)){
               System.out.println("[ACCESS DENIED] You lack permission to view:"+ fileName);
               return;
           }
           if("ADMIN".equals(userRole)){
               if(realImage==null){
                   realImage=new RealImage(fileName);
               }
               realImage.show();
           }
        }
    }
    public class ProxyPattern {
    public static void main(String[] args) {
        Image image1=new ProxyImage("cat.txt", "GUEST");
        Image image2=new ProxyImage("dragon.txt", "ADMIN");

        image1.show();
        image2.show();


    }
    }

