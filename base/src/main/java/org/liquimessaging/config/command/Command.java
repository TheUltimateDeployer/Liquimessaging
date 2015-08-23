package org.liquimessaging.config.command;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;

@XmlType
@XmlEnum(String.class)
public enum Command{
    @XmlEnumValue("create") CREATE,
    @XmlEnumValue("modify") MODIFY,
    @XmlEnumValue("delete") DELETE
}
