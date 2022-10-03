import { registerPlugin } from '@capacitor/core';

import type { DocumentReaderPlugin } from './definitions';

const DocumentReader = registerPlugin<DocumentReaderPlugin>('DocumentReader', {
  web: () => import('./web').then(m => new m.DocumentReaderWeb()),
});

export * from './definitions';
export { DocumentReader };
