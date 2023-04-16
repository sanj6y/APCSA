import java.util.ArrayList;

public class GeneTools {

    private static final String[] CODONS = { 
            "TTT", "TTC", "TTA", "TTG", "TCT", "TCC", "TCA", "TCG", "TAT", "TAC", 
			"TGT", "TGC", "TGG", "CTT", "CTC", "CTA", "CTG", "CCT", "CCC", "CCA", 
			"CCG", "CAT", "CAC", "CAA", "CAG", "CGT", "CGC", "CGA", "CGG", "ATT", 
			"ATC", "ATA", "ATG", "ACT", "ACC", "ACA", "ACG", "AAT", "AAC", "AAA",
			"AAG", "AGT", "AGC", "AGA", "AGG", "GTT", "GTC", "GTA", "GTG", "GCT",
            "GCC", "GCA", "GCG", "GAT", "GAC", "GAA", "GAG", "GGT", "GGC", "GGA", 
			"GGG"};

    private static final String[] AMINOS_PER_CODON = { 
            "F", "F", "L", "L", "S", "S", "S", "S", "Y", "Y", 
			"C", "C", "W", "L", "L", "L", "L", "P", "P", "P", 
			"P", "H", "H", "Q", "Q", "R", "R", "R", "R", "I", 
			"I", "I", "M", "T", "T", "T", "T", "N", "N", "K", 
			"K", "S", "S", "R", "R", "V", "V", "V", "V", "A", 
			"A", "A", "A", "D", "D", "E", "E", "G", "G", "G", 
			"G"};

    private static final String[] AMINO_ABBREVIATIONS = {
            "F", "L", "I", "M", "V", "S", "P", "T", "A", "Y", 
			"H", "Q", "N", "K", "D", "E", "C", "W", "R", "G" };

    private static final String[] FULL_NAMES = { 
            "phenylalanine", "leucine", "isoleucine", "methionine", "valine", 
			"serine", "proline", "threonine", "alanine", "tyrosine", 
			"histidine", "glutamine", "asparagine", "lysine", "aspartic acid", 
			"glutamic acid", "cysteine", "tryptophan", "arginine", "glycine" };

    /**
     * Return the single-letter abbreviation for a codon, e.g., "F" for "TTT"
     * (phenylalanine). This method returns "X" if the parameter is a non-valid
     * codon.
     * 
     * @param codon   is the codon whose abbreviation is returned
     *           
     * @return the one-letter abbreviation for the codon, or "X" if the codon
     *         isn't valid
     */

    public static String codonToAminoAcid(String codon) {

        for (int k = 0; k < CODONS.length; k++) {
            if (CODONS[k].equals(codon)) {
                return AMINOS_PER_CODON[k];
            }
        }

        // should only reach this for STOP codons
        return "X";
    }
}