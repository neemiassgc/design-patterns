interface Device {

	boolean isEnabled();

	void enable();
	
	void disable();

	int getVolume();

	void setVolume(int vol);

	int getChannel();

	void setChannel(int channel);
}

abstract class Remote {

	private Device device;

	protected Remote(Device device) {
		this.device = device;
	}

	protected void togglePower() {
		if (device.isEnabled()) {
			device.disable();
			System.out.println("Powered off");
			return;
		}
		device.enable();
		System.out.println("Powered on");
	}

	protected void volumeUp() {
		device.setVolume(device.getVolume() + 1);
		System.out.println("Volume up to "+device.getVolume());
	}

	protected void volumeDown() {
		device.setVolume(device.getVolume() - 1);
		System.out.println("Volume down to "+device.getVolume());
	}

	protected void channelUp() {
		device.setChannel(device.getChannel() + 1);
		System.out.println("Channel up to "+device.getChannel());
	}

	protected void channelDown() {
		device.setChannel(device.getChannel() - 1);
		System.out.println("Channel down to "+device.getChannel());
	}
}

final class TV implements Device {

	private boolean enable;
	private int vol, channel;

	private TV(boolean enable, int vol, int channel) {
		this.enable = enable;
		this.vol = vol;
		this.channel = channel;
	}

	public TV() {
		this(false, 30, 10);
	}

	public boolean isEnabled() {
		return enable;
	}

	public void enable() {
		this.enable = true;
	}
	
	public void disable() {
		this.enable = false;
	}

	public int getVolume() {
		return this.vol;
	}

	public void setVolume(int vol) {
		this.vol = vol;
	}

	public int getChannel() {
		return this.channel;
	}

	public void setChannel(int channel) {
		this.channel = channel;
	}
}

final class Radio implements Device {

	private boolean enable;
	private int vol, channel;

	private Radio(boolean enable, int vol, int channel) {
		this.enable = enable;
		this.vol = vol;
		this.channel = channel;
	}

	public Radio() {
		this(false, 15, 810);
	}

	public boolean isEnabled() {
		return enable;
	}

	public void enable() {
		this.enable = true;
	}
	
	public void disable() {
		this.enable = false;
	}

	public int getVolume() {
		return this.vol;
	}

	public void setVolume(int vol) {
		this.vol = vol;
	}

	public int getChannel() {
		return this.channel;
	}

	public void setChannel(int channel) {
		this.channel = channel;
	}
}

final class RemoteControl extends Remote {

	public RemoteControl(Device device) {
		super(device);
	}
}

final class RemoteControlDemo {

	public static void main(String[] args) {
		Device tv = new TV();
		Device radio = new Radio();

		Remote control = new RemoteControl(tv);
		control.togglePower();
		control.volumeUp();
		control.volumeUp();
		control.volumeDown();
		control.volumeUp();
		control.channelUp();
		control.togglePower();

		System.out.println();
		control = new RemoteControl(radio);
		control.togglePower();
		control.volumeUp();
		control.volumeUp();
		control.volumeDown();
		control.volumeUp();
		control.channelUp();
		control.togglePower();
	}
}