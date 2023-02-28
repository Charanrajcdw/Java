package creationalPattern;

class SmartPhone{
	String processor,camera,storage,ram;
	
	public SmartPhone(BuildPhone components){
		this.processor = components.processor;
		this.camera = components.camera;
		this.storage = components.storage;
		this.ram = components.ram;
	}

	static class BuildPhone{
		String processor,camera,storage,ram;
		public BuildPhone setProcessor(String processor) {
			this.processor=processor;
			return this;
		}
		public BuildPhone setCamera(String camera) {
			this.camera=camera;
			return this;
		}
		public BuildPhone setStorage(String storage) {
			this.storage=storage;
			return this;
		}
		public BuildPhone setRam(String ram) {
			this.ram=ram;
			return this;
		}
		public SmartPhone build() {
			return new SmartPhone(this);
		}
	}
	
	@Override
	public String toString() {
		return "Smartphone:[processor: "+processor+", camera: "+camera+", storage:"+storage+", ram:"+ram+"]";
	}
}

public class BuilderPattern {
	public static void main(String[] args) {
		SmartPhone phone1=new SmartPhone.BuildPhone().setCamera("108 MP").setProcessor("Snapdragon").setRam("8gb").setStorage("256gb").build();
		System.out.println(phone1);
		SmartPhone phone2=new SmartPhone.BuildPhone().setCamera("64 MP").setProcessor("Mediatek").setRam("6gb").setStorage("128gb").build();
		System.out.println(phone2);
	}
}
