import { WebPlugin } from '@capacitor/core';

import type { DocumentReaderPlugin } from './definitions';

export class DocumentReaderWeb extends WebPlugin implements DocumentReaderPlugin {
  async echo(options: { value: string }): Promise<{ value: string }> {
    console.log('ECHO', options);
    return options;
  }
}
