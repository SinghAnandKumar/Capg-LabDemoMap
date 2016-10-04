package com.labdemo.beans;

import com.labdemo.exception.InvalidEmployeeKeyException;

public class EmployeeKey implements Comparable<EmployeeKey> {
	String suffix = "ABC";
	int code;
	static int currentCount = 100;

	public EmployeeKey() {
		currentCount++;
		this.code = currentCount;
	}

	
	
	public EmployeeKey(String suffix, int code) {
		this.suffix = suffix;
		this.code = code;
	}



	public EmployeeKey(int code) throws InvalidEmployeeKeyException {
		if (code < 100)
			throw new InvalidEmployeeKeyException();
		else
			this.code = code;
	}

	public String getSuffix() {
		return suffix;
	}

	public void setSuffix(String suffix) {
		this.suffix = suffix;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	@Override
	public boolean equals(Object object) {
		boolean result = false;
		if (object == null || object.getClass() != getClass()) {
			result = false;
		} 
		else 
		{
			EmployeeKey obj = (EmployeeKey)object;
			if(this.suffix.equals(obj.suffix) && this.code == obj.code)
				return true;
		}
		return result;
	}

	 @Override
	 public int hashCode() {
		 return code;
	 }

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return suffix + String.valueOf(code);
	}

	@Override
	public int compareTo(EmployeeKey o) {
		return this.code - o.code;
	}

	public int getCurrentCount() {
		return currentCount;
	}

	public EmployeeKey generateKey() throws InvalidEmployeeKeyException {
		return (new EmployeeKey());
	}

}
