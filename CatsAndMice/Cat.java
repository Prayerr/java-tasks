package CatsAndMice;

import java.util.*;

public class Cat {
    private String name;
    private double speed;
    private double weight;
    private List<Mouse> caughtMice;

    public Cat(String name, double speed, double weight) {
        setName(name);
        setSpeed(speed);
        setWeight(weight);
        this.caughtMice = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public double getSpeed() {
        return speed;
    }

    public double getWeight() {
        return weight;
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Имя кота не может быть пустым");
        }
        this.name = name;
    }

    public void setSpeed(double speed) {
        if (speed <= 0) {
            throw new IllegalArgumentException("Скорость кота должна быть положительной");
        }
        this.speed = speed;
    }

    public void setWeight(double weight) {
        if (weight <= 0) {
            throw new IllegalArgumentException("Вес кота должен быть положительным");
        }
        this.weight = weight;
    }

    public void catchMouse(Mouse mouse) {
        if (caughtMice.size() >= 100) {
            System.out.println(name + " не может поймать больше мышей");
            return;
        }
        if (this.speed > mouse.getSpeed()) {
            caughtMice.add(mouse);
            System.out.println(name + " поймал мышь со скоростью " + mouse.getSpeed());
        } else {
            System.out.println(name + " не смог поймать мышь скорость мыши слишком высока");
        }
    }

    public void attackCat(Cat otherCat) {
        if (this.weight > otherCat.getWeight()) {
            System.out.println(name + " напал на " + otherCat.getName() + " и отобрал его мышей");
            this.caughtMice.addAll(otherCat.caughtMice);
            otherCat.caughtMice.clear();
        } else {
            System.out.println(name + " не смог напасть на " + otherCat.getName());
        }
    }

    @Override
    public String toString() {
        return name + " Скорость: " + speed + " м/с, Вес: " + weight + " кг, Поймано мышей: " + caughtMice.size();
    }
}
