package ico.fes.poo.modelo;


import ico.fes.poo.modelo.Plumas;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

public class ModeloTablaPluma extends AbstractTableModel {

    private ArrayList<Plumas> data;

    public ModeloTablaPluma() {
    }

    public ModeloTablaPluma(ArrayList<Plumas> data) {
        this.data = data;
    }

    @Override
    public int getRowCount() {
        return data.size();
    }

    
    @Override
    public int getColumnCount() {
        return 7;
    }
    
    @Override
    public String getColumnName(int columnIndex) {
        String columnTitle = "";

       switch (columnIndex){
                
                case 0:
                    columnTitle = "Color";
                    break;
                case 1:
                    columnTitle = "Género";
                    break;
                case 2:
                    columnTitle = "Modelo";
                    break;
                case 3:
                    columnTitle = "Longitud cm";
                    break;
                case 4:
                    columnTitle = "Peso";
                    break;
                case 5:
                    columnTitle = "Ancho de la punta";
                    break;
                case 6:
                    columnTitle = "Altura";
                    break;
                
                default:
                    columnTitle = "No Disponible";
            }
        return columnTitle;
       
    }
    
    @Override
    public Class<?> getColumnClass(int columnIndex) {
        switch (columnIndex) {
            case 0:
                return String.class;
            case 1:
                return String.class;
            case 2:
                return String.class;
            case 3:
                return Float.class;
            case 4:
                return int.class;
            case 5:
                return Float.class;
            case 6:
                return Float.class;

            default:
                return String.class;
        }
       
    }
    
    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return true;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Plumas tmp = data.get(rowIndex);
        switch (columnIndex){
            case 0:
                return tmp.getColor();
            case 1:
                return tmp.getGenero();
            case 2:
                return tmp.getModelo();
            case 3:
                return tmp.getLongitud();
            case 4:
                return tmp.getPeso();
            case 5:
                return tmp.getAncho();
            case 6:
                return tmp.getAltura();
            default:
                return null;
        
         }  
    }
    
    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        Plumas tmp=data.get(rowIndex);
        switch (columnIndex) {
            case 0:
                tmp.setColor((String)aValue);
                break;
            case 1:
                tmp.setGenero((String)aValue);
                break;
            case 2:
                tmp.setModelo((String)aValue);
                break;                
            case 3:
                tmp.setLongitud((float)aValue);
                break;
            case 4:
                tmp.setPeso(((Integer)aValue));
                break;
            case 5:
                tmp.setAncho((float)aValue);
                break;                
            case 6:
                tmp.setAltura((float)aValue);
                break;
            default:
                throw new AssertionError();
        }
        data.set(rowIndex, tmp);
        this.fireTableCellUpdated(rowIndex, columnIndex);
       
}

     public void addPlumas(Plumas nuevaPluma){
        data.add(nuevaPluma);
        this.fireTableDataChanged();
     }

   
}
     