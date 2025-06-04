
package com.mycompany.s11_hotel;

import com.mycompany.s11_hotel.view.HabitacionView;

public class Main {
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(() -> {
            new HabitacionView();
        });
    }
}
