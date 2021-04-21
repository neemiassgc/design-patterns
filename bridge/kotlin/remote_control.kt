interface Device {
	
	var vol: Int
	
	var channel: Int
	
	var enable: Boolean
}

abstract class Remote protected constructor(private val device: Device) {

	internal fun togglePower(): Unit {
		if (device.enable) {
			device.enable = false;
			println("Powered off");
			return;
		}
		device.enable = true
		println("Powered on");
	}

	internal fun volumeUp(): Unit {
		device.vol = device.vol + 1;
		println("Volume up to "+device.vol);
	}

	internal fun volumeDown(): Unit {
		device.vol = device.vol - 1;
		println("Volume down to "+device.vol);
	}

	internal fun channelUp(): Unit {
		device.channel = device.channel + 1;
		println("Channel up to "+device.channel);
	}

	internal fun channelDown(): Unit {
		device.channel = device.channel - 1;
		println("Channel down to "+device.channel);
	}
}

class TV(
	override var vol: Int,
	override var channel: Int,
	override var enable: Boolean
) : Device {

	internal constructor() : this(30, 10, false)
}

class Radio(
	override var vol: Int,
	override var channel: Int,
	override var enable: Boolean
) : Device {

	internal constructor() : this(30, 10, false)
}

class RemoteControl(private val device: Device) : Remote(device)

fun main(): Unit {
	val tv: Device = TV()
	val radio: Device = Radio()
	var control: Remote = RemoteControl(tv)

	control.togglePower();
	control.volumeUp();
	control.volumeUp();
	control.volumeDown();
	control.volumeUp();
	control.channelUp();
	control.togglePower();

	println();
	control = RemoteControl(radio);
	control.togglePower();
	control.volumeUp();
	control.volumeUp();
	control.volumeDown();
	control.volumeUp();
	control.channelUp();
	control.togglePower();
}