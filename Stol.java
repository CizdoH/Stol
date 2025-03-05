/**
 * Razred preveri kateri material je stol in odvisno od teze ce lahko oseba sedi na njemu
 *
 * @author Jakob Hodzic
 * @version Primer 35 - Stol
 */
// Glavni program
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class StolGUI extends JFrame implements ActionListener {
    private JTextField materialField, maxTezaField, visinaField;
    private JCheckBox nastavljivaVisinaBox;
    private JComboBox<String> tipStolaBox;
    private JButton dodajButton;
    private JTable stolTable;
    private StolTableModel tableModel;
    private List<Stol> stoli;

    public StolGUI() {
        setTitle("Upravljanje stolov");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        stoli = new ArrayList<>();
        tableModel = new StolTableModel();
        stolTable = new JTable(tableModel);

        JPanel inputPanel = new JPanel(new GridLayout(5, 2));
        inputPanel.add(new JLabel("Tip stola:"));
        tipStolaBox = new JComboBox<>(new String[]{"Navaden", "Pisarniski", "Barski"});
        inputPanel.add(tipStolaBox);

        inputPanel.add(new JLabel("Material:"));
        materialField = new JTextField();
        inputPanel.add(materialField);

        inputPanel.add(new JLabel("Maksimalna teza:"));
        maxTezaField = new JTextField();
        inputPanel.add(maxTezaField);

        inputPanel.add(new JLabel("Višina (samo za barski stol):"));
        visinaField = new JTextField();
        inputPanel.add(visinaField);

        inputPanel.add(new JLabel("Nastavljiva visina (samo za pisarniski stol):"));
        nastavljivaVisinaBox = new JCheckBox();
        inputPanel.add(nastavljivaVisinaBox);

        dodajButton = new JButton("Dodaj stol");
        dodajButton.addActionListener(this);
        inputPanel.add(dodajButton);

        add(inputPanel, BorderLayout.NORTH);
        add(new JScrollPane(stolTable), BorderLayout.CENTER);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            String tip = (String) tipStolaBox.getSelectedItem();
            String material = materialField.getText();
            int maxTeza = Integer.parseInt(maxTezaField.getText());

            Stol stol = null;
            if ("Navaden".equals(tip)) {
                stol = new Stol(material, maxTeza);
            } else if ("Pisarniski".equals(tip)) {
                boolean nastavljivaVisina = nastavljivaVisinaBox.isSelected();
                stol = new PisarniskiStol(material, maxTeza, nastavljivaVisina);
            } else if ("Barski".equals(tip)) {
                double visina = Double.parseDouble(visinaField.getText());
                stol = new BarskiStol(material, maxTeza, visina);
            }
            
            if (stol != null) {
                stoli.add(stol);
                tableModel.addStol(stol);
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Napaka pri vnosu podatkov!", "Napaka", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new StolGUI().setVisible(true));
    }
}

class StolTableModel extends DefaultTableModel {
    private final String[] columnNames = {"Tip", "Material", "Maksimalna teza", "Dodatne lastnosti"};
    private final List<Object[]> data = new ArrayList<>();

    @Override
    public int getRowCount() {
        return data == null ? 0 : data.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int row, int col) {
        return data.get(row)[col];
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }

    public void addStol(Stol stol) {
        String tip = stol.getClass().getSimpleName();
        String dodatno = "";
        if (stol instanceof PisarniskiStol) {
            dodatno = "Nastavljiva visina: " + ((PisarniskiStol) stol).isNastavljivaVisina();
        } else if (stol instanceof BarskiStol) {
            dodatno = "Visina: " + ((BarskiStol) stol).getVisina();
        }
        data.add(new Object[]{tip, stol.material, stol.maxTeza, dodatno});
        fireTableDataChanged();
    }
}

