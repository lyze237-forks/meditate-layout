package facebook.yoga;

public class YGValue //Type originates from: YGValue.h
{
  public float value;
  public YGUnit unit;

  public float getValue() {
    return value;
  }

  public YGUnit getUnit() {
    return unit;
  }

  public YGValue(YGUnit unit) {
    this.unit = unit;
  }

  public YGValue(float value) {
    this.value = value;
  }

  public YGValue(float value, YGUnit unit) {
    this.value = value;
    this.unit = unit;
  }
}