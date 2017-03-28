/**
 * @author Amell Peralta
 * @version 1.0 3/17/2017
 */

package org.amell.youref.main;

public interface BibliographyRepository {
	
	Iterable<Bibliography> findAll();

	Bibliography save(Bibliography bibliography);

	Bibliography findBibliography(Long id);

	void deleteBibliography(Long id);
}
