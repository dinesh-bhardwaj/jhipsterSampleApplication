import { BaseEntity } from './../../shared';

export class RNS_CATG_MASTER implements BaseEntity {
    constructor(
        public id?: number,
        public cATGCODE?: string,
        public cATGCODEDESC?: string,
        public cATGCODES?: BaseEntity[],
    ) {
    }
}
